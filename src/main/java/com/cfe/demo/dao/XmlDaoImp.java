package com.cfe.demo.dao;

import com.cfe.demo.models.CFE;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class XmlDaoImp () {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void sendXml (CFE cfe) {
        entityManager.merge(cfe);
    }
}
