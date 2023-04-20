package com.example.demoxml.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "to")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class To {

    @XmlAttribute
    Long service;

    @XmlAttribute
    Long account;

    @XmlAttribute
    BigDecimal amount;

    @XmlAttribute
    Integer currency;

    @XmlAttribute
    BigDecimal commission;

    @XmlAttribute(name = "payer_info")
    String payerInfo;

    @XmlAttribute(name = "obl_code")
    String oblCode;

    @XmlAttribute(name = "obl_text")
    String oblText;

    @XmlAttribute(name = "res_code")
    String resCode;

    @XmlAttribute(name = "res_text")
    String resText;

    @XmlAttribute(name = "uchastok_code")
    Long uchastokCode;

    @XmlAttribute(name = "uchastok_text")
    String uchastokText;
}
