package com.example.demoxml.service;

import com.example.demoxml.model.xml.CheckPaymentRequisites;
import com.example.demoxml.model.xml.Providers;
import com.example.demoxml.model.xml.Request;
import com.example.demoxml.model.xml.Response;

public interface ValidateService {

    Response checkInputData(Request request);
}
