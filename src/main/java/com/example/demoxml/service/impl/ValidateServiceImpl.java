package com.example.demoxml.service.impl;

import com.example.demoxml.enums.StatusAccount;
import com.example.demoxml.model.entity.Requisite;
import com.example.demoxml.model.xml.*;
import com.example.demoxml.service.RequisiteService;
import com.example.demoxml.service.ValidateService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Objects;

@Service
public class ValidateServiceImpl implements ValidateService {

    private final RequisiteService requisiteService;

    public ValidateServiceImpl(RequisiteService requisiteService) {
        this.requisiteService = requisiteService;
    }

    @Override
    public Response checkInputData(Request request) {
        Auth auth = request.getAuth();
        Providers providers = request.getProviders();

        CheckPaymentRequisites checkPaymentRequisites = providers.getCheckPaymentRequisites();
        AddOfflinePayment addOfflinePayment = providers.getAddOfflinePayment();

        if (checkPaymentRequisites != null) {
            PaymentXml paymentXml = checkPaymentRequisites.getPaymentXml();
            To to = paymentXml.getTo();
            return getResponseInCheckRequisite(auth, providers, checkPaymentRequisites, paymentXml, to);
        } else if (addOfflinePayment != null) {
            PaymentXml paymentXml = addOfflinePayment.getPaymentXml();
            To to = paymentXml.getTo();
            return getResponseInAddPayment(auth, providers, addOfflinePayment, paymentXml, to);
        }
        return null;
    }

    private Response getResponseInAddPayment(Auth auth,
                                             Providers providers,
                                             AddOfflinePayment addOfflinePayment,
                                             PaymentXml paymentXml,
                                             To to) {
        Response response = null;
        int result = 0;
        String message = null;

        if (checkLoginAndPassword(auth.getLogin(), auth.getSign())) {
            result = 150;
            message = "Неверный логин или пароль.";
        } else if (to.getService() / 100 == 9) {
            result = 74;
            message = "Шлюз не может принимать платежи";
        } else if (to.getService() / 100 == 6) {
            result = 130;
            message = "Работа с данным поставщиком услуги не реализована";
        } else if (incorrectInputData(to.getService(), to.getAccount(), to.getAmount())) {
            result = 202;
            message = "Ошибка данных запроса.";
        } else if (amountTooLittle(to.getAmount())) {
            result = 241;
            message = "Сумма слишком мала";
        } else if (amountTooBig(to.getAmount())) {
            result = 242;
            message = "Сумма слишком велика";
        } else if (accountNotActive(to.getAccount())) {
            result = 79;
            message = "Счет абонента не активен.";
        }

        if (result != 0) {
            response = new Response();
            ErrorProblem errorProblem = new ErrorProblem();
            errorProblem.setMessage(message);

            paymentXml.setResult(result);
            paymentXml.setStatus(0);
            paymentXml.setTo(null);

            response.setResult(result);
            addOfflinePayment.setPaymentXml(paymentXml);
            addOfflinePayment.setErrorProblem(errorProblem);

            providers.setAddOfflinePayment(addOfflinePayment);
            response.setProviders(providers);
        }
        return response;
    }

    private boolean amountTooBig(BigDecimal amount) {
        boolean result = false;
        if (amount != null) {
            result = amount.compareTo(new BigDecimal(200000)) > 0;
        }
        return result;
    }

    private boolean amountTooLittle(BigDecimal amount) {
        boolean result = false;
        if (amount != null) {
            result = amount.compareTo(new BigDecimal(100)) < 0;
        }
        return result;
    }

    private Response getResponseInCheckRequisite(Auth auth,
                                                 Providers providers,
                                                 CheckPaymentRequisites checkPaymentRequisites,
                                                 PaymentXml paymentXml,
                                                 To to) {
        Response response = null;
        int result = 0;
        String message = null;

        if (checkLoginAndPassword(auth.getLogin(), auth.getSign())) {
            result = 150;
            message = "Неверный логин или пароль.";
        } else if (incorrectInputData(to.getService(), to.getAccount(), to.getAmount())) {
            result = 202;
            message = "Ошибка данных запроса.";
        } else if (to.getService() / 100 == 9) {
            result = 130;
            message = "Работа с данным поставщиком услуги не реализована.";
        } else if (to.getService() / 100 != 8) {
            result = 5;
            message = "Номер не принадлежит оператору. Неправильный реквизит услуги.";
        } else if (accountBlocked(to.getAccount())) {
            result = 153;
            message = "Персона временно заблокирована. Неудачные попытки пароля.";
        } else if (accountNotActive(to.getAccount())) {
            result = 79;
            message = "Счет абонента не активен.";
        }

        if (result != 0) {
            response = new Response();
            ErrorProblem errorProblem = new ErrorProblem();
            errorProblem.setMessage(message);

            paymentXml.setResult(result);
            paymentXml.setStatus(0);
            paymentXml.setTo(null);

            response.setResult(result);
            checkPaymentRequisites.setPaymentXml(paymentXml);
            checkPaymentRequisites.setErrorProblem(errorProblem);

            providers.setCheckPaymentRequisites(checkPaymentRequisites);
            response.setProviders(providers);
        }

        return response;
    }

    private boolean notExistAccount(Long account) {
        return requisiteService.findByAccount(account) == null;
    }

    private boolean incorrectInputData(Long service, Long account, BigDecimal amount) {
        return service < 100
                || account < 100
                || amount.compareTo(new BigDecimal(0)) == 0
                || amount.compareTo(new BigDecimal(0)) < 0;
    }

    private boolean checkLoginAndPassword(String login, String sign) {
        return !(Objects.equals(login, "login") && Objects.equals(sign, "password"));
    }

    private boolean accountNotActive(Long account) {
        boolean result = false;
        Requisite requisite = requisiteService.findByAccount(account);
        if (requisite != null) {
            result = requisite.getStatusAccount() == StatusAccount.NOT_ACTIVE;
        }
        return result;
    }

    private boolean accountBlocked(Long account) {
        boolean result = false;
        Requisite requisite = requisiteService.findByAccount(account);
        if (requisite != null) {
            result = requisite.getStatusAccount() == StatusAccount.BLOCKED;
        }
        return result;
    }
}
