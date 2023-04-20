package com.example.demoxml.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "paymentXml")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class PaymentXml {

    @XmlAttribute
    Long id;

    @XmlAttribute
    Integer result;

    @XmlAttribute
    Integer status;

    @XmlAttribute
    Integer uid;

    @XmlAttribute
    String subscriber;

    @XmlElement
    To to;
}
