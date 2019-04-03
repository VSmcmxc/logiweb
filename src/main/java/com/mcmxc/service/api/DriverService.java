package com.mcmxc.service.api;

import com.mcmxc.entities.Driver;
import com.mcmxc.entities.User;

public interface DriverService extends GenericService<Driver,Integer>{
    void addDriver(User user, Driver driver);
    void saveOrUpdate (User user, Driver driver);

}
