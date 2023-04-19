package com.example.demoxml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "provider")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

    @XmlAttribute(name = "id")
    private Integer id;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "orderId")
    private String orderId;

    @XmlAttribute(name = "logo")
    private String logo;
}
