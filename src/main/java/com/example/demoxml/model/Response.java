package com.example.demoxml.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    @XmlAttribute(name = "result")
    private Integer result;

    @XmlElement(name = "providers")
    private Providers providers;
}
