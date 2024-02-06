package com.cfe.demo.dao;

import com.cfe.demo.models.ETck;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class XmlDaoImp {
    @PersistenceContext
    EntityManager entityManager;


    public void sendXml (ETck eTck) {
        entityManager.merge(eTck);
    }
}
