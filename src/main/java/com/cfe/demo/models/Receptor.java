package com.cfe.demo.models;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Receptor")
@XmlType(propOrder={"TipoDocRecep", "CodPaisRecep", "DocRecep", "RznSocRecep", "DirRecep", "CiudadRecep", "DeptoRecep"})
public class Receptor {
    @XmlElement(name="TipoDocRecep", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private Integer TipoDocRecep; // NUM 2
    /*
        Indica si se trata de NIE,
RUC, C.I. Otros,
Pasaporte, DNI o NIFE:
1: NIE
2: RUC (Uruguay)
3: C.I. (Uruguay)
4: Otros
5: Pasaporte (todos los
países)
6: DNI (documento de
identidad de Argentina,
Brasil, Chile o
Paraguay)
7: NIFE: número de
identificación fiscal
extranjero (todos los
países
     */

    @XmlElement(name="CodPaisRecep", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String CodPaisRecep; // ALPHA 2

    @XmlElement(name="DocRecep", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private int DocRecep; // NUM 12

    @XmlElement(name="RznSocRecep", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String RznSocRecep; // ALPHA 150

    @XmlElement(name="DirRecep", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String DirRecep; // ALPHA 70

    @XmlElement(name="CiudadRecep", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String CiudadRecep; // ALPHA 30

    @XmlElement(name="DeptoRecep", namespace = "http://cfe.dgi.gub.uy")
    @Getter @Setter
    private String DeptoRecep; // ALPHA 30
}
