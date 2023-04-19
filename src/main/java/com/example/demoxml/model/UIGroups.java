package com.example.demoxml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getUIGroups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UIGroups {

    @XmlAttribute(name = "result")
    private Integer result;

//    @XmlElement(name = "group")
    private List<Group> groups;
}
