package com.mcmxc.dao.imp;

import com.mcmxc.dao.DaoException;
import com.mcmxc.dao.api.TruckDao;
import com.mcmxc.entities.Truck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TruckDaoImp extends GenericDaoImp<Truck, Integer> implements TruckDao {

    private static final Logger logger = LoggerFactory.getLogger(TruckDaoImp.class);

    @Override
    public Truck findByNumber(String number) throws DaoException {
            try {
                Query query = currentSession()
                        .createQuery(
                                "SELECT t FROM Truck t WHERE number = :number");
                query.setParameter("number", number);

                List<Truck> resultList = query.getResultList();
                if(resultList.isEmpty()) {
                    return null;
                } else {
                    return resultList.get(0);
                }
            } catch (Exception e) {
                logger.warn(e.toString());
                throw new DaoException(e);
            }
    }
}
