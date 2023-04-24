package com.example.demoxml.service;

import com.example.demoxml.model.xml.PaymentXml;
import com.example.demoxml.model.xml.Request;
import com.example.demoxml.model.xml.Response;

public interface PaymentService {

    Response addOfflinePayment(Request request);

    Response getExistPaymentStatus(PaymentXml paymentXml);

    Response getPaymentStatus(Request request);
}
