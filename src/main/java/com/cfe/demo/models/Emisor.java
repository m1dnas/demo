package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Emisor", namespace = "http://cfe.dgi.gub.uy", propOrder = {
        "RUCEmisor",
        "RznSoc",
        "CdgDGISucur",
        "DomFiscal",
        "Ciudad",
        "Departamento"
})
public class Emisor {
    @XmlElement(name="RUCEmisor")
    @Getter @Setter
    private String RUCEmisor; // NUM 12 tipo string pq es 12

    @XmlElement(name="RznSoc")
    @Getter @Setter
    private String RznSoc;

    @XmlElement(name="CdgDGISucur")
    @Getter @Setter
    private Integer CdgDGISucur; // NUM 4; codigo numerico entregado por la DGI q identifica a la casa principal o a ala sucursal donde se realiza la operación

    @XmlElement(name="DomFiscal")
    @Getter @Setter
    private String DomFiscal; // ALPHA 70

    @XmlElement(name="Ciudad")
    @Getter @Setter
    private String Ciudad;

    @XmlElement(name="Departamento")
    @Getter @Setter
    private String Departamento;
}
