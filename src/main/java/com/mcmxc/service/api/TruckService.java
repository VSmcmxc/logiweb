package com.mcmxc.service.api;

import com.mcmxc.entities.Truck;
import com.mcmxc.service.exceprions.LogiwebServiceException;
import com.mcmxc.service.exceprions.ServiceValidationException;

public interface TruckService extends GenericService<Truck, Integer> {

    Truck addTruck(Truck newTruck) throws ServiceValidationException, LogiwebServiceException;

}
