package com.example.demoxml.controller;

import com.example.demoxml.model.xml.Request;
import com.example.demoxml.model.xml.Response;
import com.example.demoxml.service.PaymentService;
import com.example.demoxml.service.ValidateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
public class PaymentController {

    private final PaymentService paymentService;

    private final ValidateService validateService;

    public PaymentController(PaymentService paymentService,
                             ValidateService validateService) {
        this.paymentService = paymentService;
        this.validateService = validateService;
    }

    @PostMapping(value = "/addOfflinePayment", produces = {"application/xml"})
    public Response addOfflinePayment(@RequestBody Request request) {
        Response response = validateService.checkInputData(request);
        if (response != null) {
            return response;
        }
        return paymentService.addOfflinePayment(request);
    }

    @PostMapping(value = "/getPaymentStatus", produces = {"application/xml"})
    public Response getPaymentStatus(@RequestBody Request request) {
        return paymentService.getPaymentStatus(request);
    }
}
