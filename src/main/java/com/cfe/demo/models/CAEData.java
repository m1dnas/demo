package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name= "CAEData", propOrder={"CAE_ID", "DNro", "HNro", "FecVenc"})
public class CAEData {
    @XmlElement(name="CAE_ID")
    @Getter @Setter
    private Integer CAE_ID;

    @XmlElement(name="DNro")
    @Getter @Setter
    private Integer DNro;

    @XmlElement(name="HNro")
    @Getter @Setter
    private Integer HNro;

    @XmlElement(name="FecVenc")
    @Getter @Setter
    private String FecVenc;
}
