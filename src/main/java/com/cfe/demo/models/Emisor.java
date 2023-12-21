package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

//@XmlRootElement(name = "Emisor")
//@XmlType(propOrder={"RUCEmisor", "RznSoc", "CdgDGISucur", "DomFiscal", "Ciudad", "Departamento"})
public class Emisor {
    @XmlElement(name="RUCEmisor")
    @Getter @Setter
    private String rucEmisor; // NUM 12 tipo string pq es 12

    @XmlElement(name="RznSoc")
    @Getter @Setter
    private String razonSocial;

    @XmlElement(name="CdgDGISucur")
    @Getter @Setter
    private Integer cdgDgiSucur; // NUM 4; codigo numerico entregado por la DGI q identifica a la casa principal o a ala sucursal donde se realiza la operación

    @XmlElement(name="DomFiscal")
    @Getter @Setter
    private String domicilioFiscal; // ALPHA 70

    @XmlElement(name="Ciudad")
    @Getter @Setter
    private String ciudad;

    @XmlElement(name="Departamento")
    @Getter @Setter
    private String departamento;
}
