package com.example.demoxml.service.impl;

import com.example.demoxml.model.entity.Payment;
import com.example.demoxml.model.xml.*;
import com.example.demoxml.repository.PaymentRepository;
import com.example.demoxml.service.PaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Response addOfflinePayment(Request request) {
        Providers providers = request.getProviders();
        AddOfflinePayment addOfflinePayment = providers.getAddOfflinePayment();
        PaymentXml paymentXml = addOfflinePayment.getPaymentXml();

        Optional<Payment> optionalPayment = paymentRepository.findById(paymentXml.getId());
        if (optionalPayment.isPresent()) {
            return getPaymentStatus(paymentXml);
        }

        To to = paymentXml.getTo();

        Payment payment = new Payment();
        payment.setId(paymentXml.getId());
        payment.setAmount(to.getAmount());
        payment.setCommission(to.getCommission());
        payment.setCurrency(to.getCurrency());
        payment.setStatus(3);
        paymentRepository.save(payment);

        addOfflinePayment.setResult(0);
        paymentXml.setResult(0);
        paymentXml.setStatus(3);
        paymentXml.setUid(123);
        paymentXml.setTo(null);

        Response response = new Response();
        response.setResult(0);
        response.setProviders(providers);

        return response;
    }

    @Override
    public Response getPaymentStatus(PaymentXml paymentXml) {
        Response response = new Response();
        Providers providers = new Providers();

        GetPaymentStatus getPaymentStatus = new GetPaymentStatus();

        paymentXml.setResult(0);
        paymentXml.setUid(123);
        paymentXml.setStatus(0);
        paymentXml.setTo(null);

        getPaymentStatus.setPaymentXml(paymentXml);
        providers.setGetPaymentStatus(getPaymentStatus);
        response.setProviders(providers);
        response.setResult(0);

        return response;
    }
}
