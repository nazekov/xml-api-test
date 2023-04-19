package com.example.demoxml.model.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @XmlAttribute
    private Long id;

    @XmlAttribute
    private Integer result;

    @XmlAttribute
    private Integer status;

    @XmlAttribute
    private String subscriber;

    @XmlElement
    private To to;
}
