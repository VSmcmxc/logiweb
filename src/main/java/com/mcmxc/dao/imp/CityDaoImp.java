package com.mcmxc.dao.imp;

import com.mcmxc.dao.api.CityDao;
import com.mcmxc.entities.City;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CityDaoImp extends GenericDaoImp<City, Integer> implements CityDao {

    private static final Logger logger = LoggerFactory.getLogger(CityDaoImp.class);

    @Override
    public City findUniqueByName(String cityName) {
        Query query = currentSession().createQuery(
                "from City c where c.cityName=:cityName");
        query.setParameter("cityName", cityName);
        logger.info("City successfully loaded. City details: " + cityName);
        return (City) query.uniqueResult();
    }

    @Override
    public List<City> findAllByName(String cityName) {
        /*Query query = currentSession().createQuery(
                "from City " +
                        "where cityName like :cityName");
        query.setParameter("cityName", "%" + cityName + "%");
        logger.info("Cities successfully loaded. Cities names like: " + cityName);
        return query.getResultList();*/
        return null;
    }
}
