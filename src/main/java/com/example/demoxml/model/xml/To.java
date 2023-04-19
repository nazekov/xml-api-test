package com.example.demoxml.model.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "to")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class To {

    @XmlAttribute
    private Long service;

    @XmlAttribute
    private Long account;

    @XmlAttribute
    private Long amount;

    @XmlAttribute(name = "obl_code")
    private String oblCode;

    @XmlAttribute(name = "obl_text")
    private String oblText;

    @XmlAttribute(name = "res_code")
    private String resCode;

    @XmlAttribute(name = "res_text")
    private String resText;

    @XmlAttribute(name = "uchastok_code")
    private Long uchastokCode;

    @XmlAttribute(name = "uchastok_text")
    private String uchastokText;
}
