package com.example.demoxml.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "providers")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Providers {

//    @XmlElement(name = "getUIGroups")
//    private UIGroups uiGroups;

    @XmlElement(name = "checkPaymentRequisites")
    CheckPaymentRequisites checkPaymentRequisites;
}
