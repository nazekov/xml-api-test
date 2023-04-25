package com.example.demoxml.model.xml;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "errorProblem")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class ErrorProblem {

    @XmlAttribute
    String message;
}
