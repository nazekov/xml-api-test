package com.example.demoxml.model.xml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "group")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @XmlAttribute(name = "id")
    private Integer id;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "orderId")
    private Integer orderId;

    @XmlAttribute(name = "logo")
    private String logo;

//    @XmlElement(name = "provider")
    private List<Provider> providers;
}
