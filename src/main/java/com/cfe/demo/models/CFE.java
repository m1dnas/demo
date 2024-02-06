package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="CFE", namespace = "http://cfe.dgi.gub.uy")
@XmlType(propOrder = {"eTck"})
public class CFE {
    @XmlAttribute
    @Getter @Setter
    private String version;


    @XmlElement(name = "eTck", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private ETck eTck;
}
