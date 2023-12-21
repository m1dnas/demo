package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class Detalle {
    @XmlElementWrapper(name= "Detalle")
    @XmlElement(name="Item")
    @Getter @Setter
    private List<Item> items;
}
