package com.mcmxc.service.imp;

import com.mcmxc.dao.api.DriverDao;
import com.mcmxc.dao.api.GenericDao;
import com.mcmxc.dao.api.UserDao;
import com.mcmxc.entities.Driver;
import com.mcmxc.entities.User;
import com.mcmxc.service.api.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DriverServiceImp extends GenericServiceImp<Driver, Integer>
        implements DriverService {


    private DriverDao driverDao;

    private UserDao userDao;

    public DriverServiceImp() {

    }
    @Autowired
    public DriverServiceImp(
            @Qualifier("driverDaoImp") GenericDao<Driver, Integer> genericDao) {
        super(genericDao);
        this.driverDao = (DriverDao) genericDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addDriver(User user, Driver driver) {
        userDao.add(user);
        driver.setDriverUser(user);
        driverDao.add(driver);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(User user, Driver driver) {
        userDao.saveOrUpdate(user);
        driver.setDriverUser(user);
        driverDao.saveOrUpdate(driver);
    }
}
