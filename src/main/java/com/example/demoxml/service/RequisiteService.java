package com.example.demoxml.service;

import com.example.demoxml.model.xml.Request;
import com.example.demoxml.model.xml.Response;

public interface RequisiteService {

    Response findPersonByAccountRequest(Request request);
}
