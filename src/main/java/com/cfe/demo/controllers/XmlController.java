package com.cfe.demo.controllers;

import com.cfe.demo.models.CFE;
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

    @RequestMapping(value = "api/xml", method = RequestMethod.POST)
    public void sendXml(@RequestBody CFE cfe) throws JAXBException {

        XMLGenerator newCFE = new XMLGenerator(2);
        //xmlDao.sendXml(cfe);
    }
}
