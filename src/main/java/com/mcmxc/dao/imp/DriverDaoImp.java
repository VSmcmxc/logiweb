package com.mcmxc.dao.imp;

import com.mcmxc.dao.api.DriverDao;
import com.mcmxc.entities.Driver;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DriverDaoImp extends GenericDaoImp<Driver, Integer> implements DriverDao {

    private static final Logger logger = LoggerFactory.getLogger(DriverDaoImp.class);

    private SessionFactory sessionFactory;

    public DriverDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


}
