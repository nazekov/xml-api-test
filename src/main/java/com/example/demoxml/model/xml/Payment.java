package com.example.demoxml.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

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
