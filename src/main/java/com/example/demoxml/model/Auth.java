package com.example.demoxml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auth")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    @XmlAttribute(name = "login")
    private String login;

    @XmlAttribute(name = "sign")
    private String sign;

    @XmlAttribute(name = "signAlg")
    private String signAlg;

//    public Auth() {
//    }
//
//    public Auth(String login, String sign, String signAlg) {
//        this.login = login;
//        this.sign = sign;
//        this.signAlg = signAlg;
//    }
//
//    @XmlAttribute(name = "login")
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    @XmlAttribute(name = "sign")
//    public String getSign() {
//        return sign;
//    }
//
//    public void setSign(String sign) {
//        this.sign = sign;
//    }
//
//    @XmlAttribute(name = "signAlg")
//    public String getSignAlg() {
//        return signAlg;
//    }
//
//    public void setSignAlg(String signAlg) {
//        this.signAlg = signAlg;
//    }
}
