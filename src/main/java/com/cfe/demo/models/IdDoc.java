package com.cfe.demo.models;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

public class IdDoc {
    @XmlElement(name="TipoCFE")
    @Getter @Setter
    private Integer tipoCFE;

    @XmlElement(name="Serie")
    @Getter @Setter
    private String serie; // ALPHA 2

    @XmlElement(name="Nro")
    @Getter @Setter
    private Integer num; // NUM 7 - asignado al comprobante; 1 <= nro <= 9999999

    @XmlElement(name="FchEmis")
    @Getter @Setter
    private String fechaEmision; // (2013-05-11) - fecha del comprobante; hacer función

    @XmlElement(name="MntBruto")
    @Getter @Setter
    private Integer montoBruto; // NUM 1

    @XmlElement(name="FmaPago")
    @Getter @Setter
    private Integer formaPago; // NUM 1

    @XmlElement(name="fchVenc")
    @Getter @Setter
    private String fechaVenc; // (2013-08-21)
}
