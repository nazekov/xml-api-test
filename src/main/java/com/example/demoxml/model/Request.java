package com.example.demoxml.model;

import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Request {

    private Auth auth;

    private Providers providers;

//    public Request() {
//    }
//
//    public Request(Auth auth, Providers providers) {
//        this.auth = auth;
//        this.providers = providers;
//    }
//
//    @XmlElement(name = "auth")
//    public Auth getAuth() {
//        return auth;
//    }
//
//    public void setAuth(Auth auth) {
//        this.auth = auth;
//    }
//
//    @XmlElement(name = "providers")
//    public Providers getProviders() {
//        return providers;
//    }
//
//    public void setProviders(Providers providers) {
//        this.providers = providers;
//    }
}
