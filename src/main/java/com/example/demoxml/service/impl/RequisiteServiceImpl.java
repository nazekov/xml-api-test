package com.example.demoxml.service.impl;

import com.example.demoxml.model.entity.Requisite;
import com.example.demoxml.model.xml.*;
import com.example.demoxml.repository.RequisiteRepository;
import com.example.demoxml.service.RequisiteService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RequisiteServiceImpl implements RequisiteService {

    private final RequisiteRepository requisiteRepository;

    public RequisiteServiceImpl(RequisiteRepository requisiteRepository) {
        this.requisiteRepository = requisiteRepository;
    }

    @Override
    public Response findPersonByAccountRequest(Request request) {
        Optional<Requisite> optionalPerson = requisiteRepository.findByAccount(request
                .getProviders()
                .getCheckPaymentRequisites()
                .getPaymentXml()
                .getTo()
                .getAccount()
        );
        Response response = new Response();
        response.setResult(0);
        response.setProviders(request.getProviders());

        CheckPaymentRequisites checkPaymentRequisites
                = response.getProviders().getCheckPaymentRequisites();
        PaymentXml paymentXml = checkPaymentRequisites.getPaymentXml();
        paymentXml.setResult(0);

        int status = 0;
        String subscriber = "Абонент не найден";

        if (optionalPerson.isPresent()) {
            Requisite requisite = optionalPerson.get();
            status = 3;
            subscriber = requisite.getFirstName() +
                            " " + requisite.getLastName() +
                            " " + requisite.getPatronymic();
        }
        paymentXml.setStatus(status);
        paymentXml.setSubscriber(subscriber);
        paymentXml.setTo(null);
        checkPaymentRequisites.setExtras(new Extras(subscriber));
        return response;
    }
}
