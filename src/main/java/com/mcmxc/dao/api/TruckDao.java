package com.mcmxc.dao.api;

import com.mcmxc.dao.DaoException;
import com.mcmxc.entities.Truck;

public interface TruckDao extends GenericDao<Truck, Integer> {
    Truck findByNumber(String number) throws DaoException;

}
