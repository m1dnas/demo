package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Emisor")
@XmlType(propOrder={"RUCEmisor", "RznSoc", "CdgDGISucur", "DomFiscal", "Ciudad", "Departamento"})
public class Emisor {
    @XmlElement(name="RUCEmisor", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String RUCEmisor; // NUM 12 tipo string pq es 12

    @XmlElement(name="RznSoc", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String RznSoc;

    @XmlElement(name="CdgDGISucur", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer CdgDGISucur; // NUM 4; codigo numerico entregado por la DGI q identifica a la casa principal o a ala sucursal donde se realiza la operación

    @XmlElement(name="DomFiscal", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String DomFiscal; // ALPHA 70

    @XmlElement(name="Ciudad", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String Ciudad;

    @XmlElement(name="Departamento", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String Departamento;
}
