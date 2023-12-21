package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

public class Receptor {
    @XmlElement(name="TipoDocRecep")
    @Getter @Setter
    private Integer tipoDocRecep; // NUM 2

    @XmlElement(name="CodPaisRecep")
    @Getter @Setter
    private String codPaisRecep; // ALPHA 2

    @XmlElement(name="DocRecep")
    @Getter @Setter
    private String docRecep; // NUM 12

    @XmlElement(name="RznSocRecep")
    @Getter @Setter
    private String razonSocRecep; // ALPHA 150

    @XmlElement(name="DirRecep")
    @Getter @Setter
    private String dirRecep; // ALPHA 70

    @XmlElement(name="CiudadRecep")
    @Getter @Setter
    private String ciudadRecep; // ALPHA 30

    @XmlElement(name="DeptoRecep")
    @Getter @Setter
    private String deptoRecep; // ALPHA 30
}
