package com.mcmxc.service.api;

import com.mcmxc.entities.City;
import com.mcmxc.service.exceprions.LogiwebServiceException;

import java.util.List;

public interface CityService extends GenericService<City,Integer>{
    City findUniqueByName(String name);
    List<City> findAllCitiesByName(String query);

    List<City> findAllCities() throws LogiwebServiceException;

}
