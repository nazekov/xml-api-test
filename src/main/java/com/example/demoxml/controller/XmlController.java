package com.example.demoxml.controller;

import com.example.demoxml.model.xml.CheckPaymentRequisites;
import com.example.demoxml.model.xml.Payment;
import com.example.demoxml.model.xml.Providers;
import com.example.demoxml.model.xml.Request;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class XmlController {

//    @PostMapping(value = "/getUIGroups", produces = {"application/xml"})
//    public Response getUIGroups() {
//        Response response = new Response();
//        response.setResult(0);
//
//        Providers providers = new Providers();
//        UIGroups uiGroups = new UIGroups();
//        uiGroups.setResult(0);
//
//        Group group1 = new Group();
//        group1.setId(1);
//        group1.setName("Сотовая связь");
//        group1.setOrderId(1);
//        group1.setLogo("logo.png");
//
//        Provider provider1 = new Provider();
//        provider1.setId(1);
//        provider1.setName("Megacom");
//        provider1.setLogo("mega.png");
//
//        Provider provider2 = new Provider();
//        provider2.setId(1);
//        provider2.setName("Beeline");
//        provider2.setLogo("beeline.png");
//
//        List<Provider> providersList = Arrays.asList(
//            provider1, provider2
//        );
//
//        group1.setProviders(providersList);
//
//        uiGroups.setGroups(Arrays.asList(group1));
//
//        providers.setUiGroups(uiGroups);
//
//        response.setProviders(providers);
//
//        return response;
//    }

    @PostMapping(value = "/checkPaymentRequisites", produces = {"application/xml"})
    public Request checkPaymentRequisites(@RequestBody Request request) {
        Providers providers = request.getProviders();
        CheckPaymentRequisites checkPaymentRequisites = providers.getCheckPaymentRequisites();
        Payment payment = checkPaymentRequisites.getPayment();
        payment.setResult(0);
        payment.setStatus(3);
        payment.setSubscriber("Hello Hello");
        return request;
    }
}
