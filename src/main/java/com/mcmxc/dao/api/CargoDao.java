package com.mcmxc.dao.api;

import com.mcmxc.dao.DaoException;
import com.mcmxc.entities.Cargo;

import java.util.List;

public interface CargoDao extends GenericDao<Cargo, Integer> {
    Cargo findUniqueByNumber(int number) throws DaoException;
    List<Cargo> findAllByName(String name) throws DaoException;
    List<Cargo> findAll() throws DaoException;

}
