package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CAEData")
@XmlType(propOrder={"CAE_ID", "DNro", "HNro", "FecVenc"})
public class CAEData {
    @XmlElement(name="CAE_ID", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer CAE_ID;

    @XmlElement(name="DNro", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer DNro;

    @XmlElement(name="HNro", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer HNro;

    @XmlElement(name="FecVenc", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String FecVenc;
}
