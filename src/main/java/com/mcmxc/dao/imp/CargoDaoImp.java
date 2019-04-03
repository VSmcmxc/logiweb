package com.mcmxc.dao.imp;

import com.mcmxc.dao.DaoException;
import com.mcmxc.dao.api.CargoDao;
import com.mcmxc.entities.Cargo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/*@Repository*/
public class CargoDaoImp extends GenericDaoImp<Cargo, Integer> implements CargoDao {

    private static final Logger logger = LoggerFactory.getLogger(CargoDaoImp.class);

    @Override
    public Cargo findUniqueByNumber(int number) throws DaoException {
        return null;
    }

    @Override
    public List<Cargo> findAllByName(String name) throws DaoException {
        return null;
    }

    @Override
    public List<Cargo> findAll() throws DaoException {
        return null;
    }
}
