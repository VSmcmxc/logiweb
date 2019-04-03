package com.mcmxc.service.imp;

import com.mcmxc.dao.DaoException;
import com.mcmxc.dao.api.CityDao;
import com.mcmxc.dao.api.GenericDao;
import com.mcmxc.dao.api.TruckDao;
import com.mcmxc.entities.Truck;
import com.mcmxc.entities.enums.TruckStatus;
import com.mcmxc.service.api.TruckService;
import com.mcmxc.service.exceprions.LogiwebServiceException;
import com.mcmxc.service.exceprions.ServiceValidationException;
import com.mcmxc.validator.TruckNumberValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TruckServiceImp extends GenericServiceImp<Truck, Integer> implements TruckService {

    private static final Logger logger = LoggerFactory.getLogger(TruckServiceImp.class);

    private TruckDao truckDao;

    private CityDao cityDao;


    public TruckServiceImp() {
    }

    @Autowired
    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Autowired
    public TruckServiceImp(
            @Qualifier("truckDaoImp") GenericDao<Truck, Integer> genericDao) {
        super(genericDao);
        this.truckDao = (TruckDao) genericDao;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Truck addTruck(Truck newTruck) throws ServiceValidationException,
            LogiwebServiceException {
        newTruck.setTruckStatus(TruckStatus.WORKED);

        try {
            validateForEmptyFields(newTruck);
        } catch (ServiceValidationException e) {
            throw e;
        }

        if (!TruckNumberValidator.validateTruckNumber(newTruck
                .getNumber())) {
            throw new ServiceValidationException("Number "
                    + newTruck.getNumber() + " is not valid.");
        }

        try {
            Truck truckWithSameNumber = truckDao.findByNumber(newTruck.getNumber());

            if (truckWithSameNumber != null) {
                throw new ServiceValidationException("Number "
                        + newTruck.getNumber() + " is already in use.");
            }

            truckDao.saveOrUpdate(newTruck);

            logger.info("Truck added. Plate " + newTruck.getNumber()
                    + " ID: " + newTruck.getId());

            return newTruck;
        } catch (ServiceValidationException e) {
            throw e;
        } catch (DaoException e) {
            logger.warn("Something unexpected happend.", e);
            throw new LogiwebServiceException(e);
        }
    }

    private void validateForEmptyFields(Truck t) throws ServiceValidationException {
        if(t.getNumber() == null || t.getNumber().isEmpty()) {
            throw new ServiceValidationException("Number does't exist.");
        } else if (t.getDriverCapacity() <= 0) {
            throw new ServiceValidationException("Incorrect number of drivers.");
        } else if (t.getTruckSize() <= 0) {
            throw new ServiceValidationException("Incorrect capacity.");
        } else if (t.getCurrentCity() == null || t.getCurrentCity().getId() == 0) {
            throw new ServiceValidationException("City is not set.");
        }
    }

}
