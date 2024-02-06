package com.cfe.demo.controllers;

import com.cfe.demo.models.DatosCFE;
import com.cfe.demo.models.ETck;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cfe.demo.dao.XmlDao;
import com.cfe.demo.utils.marshallers.XMLGenerator;

@RestController
public class XmlController {
    //@Autowired
    private XmlDao xmlDao;

    @RequestMapping(value = "api/generar-xml", method = RequestMethod.POST)
    public String generateXml(@RequestBody DatosCFE cfe) {
        try {
            XMLGenerator xml = new XMLGenerator();
            xml.generateAndSaveXML(cfe);
            return "XML generado existosamente";
            //xmlDao.sendXml(cfe);
        } catch (JAXBException e) {
            e.printStackTrace();
            return "Error al generar el XML de la factura";
        }
    }
}
