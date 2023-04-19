package com.example.demoxml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Providers {

//    private String getUIProviders;

    @XmlElement(name = "getUIGroups")
    private UIGroups uiGroups;
//    public Providers() {
//    }
//
//    public Providers(String getUIProviders) {
//        this.getUIProviders = getUIProviders;
//    }
//
//    @XmlElement(name = "getUIProviders")
//    public String getGetUIProviders() {
//        return getUIProviders;
//    }
//
//    public void setGetUIProviders(String getUIProviders) {
//        this.getUIProviders = getUIProviders;
//    }
}
