package com.example.demoxml.model.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "providers")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Providers {

//    @XmlElement(name = "getUIGroups")
//    private UIGroups uiGroups;

    @XmlElement(name = "checkPaymentRequisites")
    private CheckPaymentRequisites checkPaymentRequisites;
}
