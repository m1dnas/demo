package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "CAEData")
@XmlType(propOrder={"CAE_ID", "DNro", "HNro", "FecVenc"})
public class CAEData {
    @XmlElement(name="CAE_ID")
    @Getter @Setter
    private Integer caeId;

    @XmlElement(name="DNro")
    @Getter @Setter
    private Integer dNro;

    @XmlElement(name="HNro")
    @Getter @Setter
    private Integer hNro;

    @XmlElement(name="FecVenc")
    @Getter @Setter
    private String fechaVencimiento;
}
