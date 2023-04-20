package com.example.demoxml.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "group")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @XmlAttribute(name = "id")
    Integer id;

    @XmlAttribute(name = "name")
    String name;

    @XmlAttribute(name = "orderId")
    Integer orderId;

    @XmlAttribute(name = "logo")
    String logo;

//    @XmlElement(name = "provider")
    List<Provider> providers;
}
