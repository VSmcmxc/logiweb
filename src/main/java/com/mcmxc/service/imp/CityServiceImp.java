package com.mcmxc.service.imp;

import com.mcmxc.dao.DaoException;
import com.mcmxc.dao.api.CityDao;
import com.mcmxc.dao.api.GenericDao;
import com.mcmxc.entities.City;
import com.mcmxc.service.api.CityService;
import com.mcmxc.service.exceprions.LogiwebServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImp extends GenericServiceImp<City, Integer>
        implements CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImp.class);

    private CityDao cityDao;

    public CityServiceImp() {

    }

    @Autowired
    public CityServiceImp(
            @Qualifier("cityDaoImp") GenericDao<City, Integer> genericDao) {
        super(genericDao);
        this.cityDao = (CityDao) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public City findUniqueByName(String name) {
        return cityDao.findUniqueByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<City> findAllCitiesByName(String query) {
        return cityDao.findAllByName(query);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<City> findAllCities() throws LogiwebServiceException {
        try {
            List<City> cities = cityDao.getAll();
            return cities;
        } catch (DaoException e) {
            logger.warn("Something unexcpected happend.");
            throw new LogiwebServiceException(e);
        }
    }
}
