package com.dahe.hello.controller.XXE;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Setter
@Getter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlElement(name = "name")
    private String name;

    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }
}
