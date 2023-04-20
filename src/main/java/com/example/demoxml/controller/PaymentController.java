package com.example.demoxml.controller;

import com.example.demoxml.model.xml.Request;
import com.example.demoxml.model.xml.Response;
import com.example.demoxml.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/addOfflinePayment", produces = {"application/xml"})
    public Response addOfflinePayment(@RequestBody Request request) {
        return paymentService.addOfflinePayment(request);
    }
}
