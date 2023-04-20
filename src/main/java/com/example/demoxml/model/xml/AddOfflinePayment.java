package com.example.demoxml.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "addOfflinePayment")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class AddOfflinePayment {

    @XmlAttribute
    Integer result;

    @XmlElement
    Payment payment;
}