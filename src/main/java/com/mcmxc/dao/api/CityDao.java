package com.mcmxc.dao.api;

import com.mcmxc.entities.City;

import java.util.List;

public interface CityDao extends GenericDao<City, Integer> {
    City findUniqueByName(String name);
    List<City> findAllByName(String name);

}
