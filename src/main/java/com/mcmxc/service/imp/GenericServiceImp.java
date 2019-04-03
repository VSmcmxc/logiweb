package com.mcmxc.service.imp;

import com.mcmxc.dao.DaoException;
import com.mcmxc.dao.api.GenericDao;
import com.mcmxc.service.api.GenericService;
import com.mcmxc.service.exceprions.LogiwebServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class GenericServiceImp<E, K>
        implements GenericService<E, K> {

    private static final Logger logger = LoggerFactory.getLogger(GenericServiceImp.class);

    private GenericDao<E, K> genericDao;

    public GenericServiceImp(GenericDao<E,K> genericDao) {
        this.genericDao=genericDao;
    }

    public GenericServiceImp() {
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(E entity) {
        genericDao.saveOrUpdate(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> getAll() throws LogiwebServiceException {
        try {
            return genericDao.getAll();
        } catch (DaoException e) {
            logger.warn("Something unexcpected happend.");
            throw new LogiwebServiceException(e);
        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public E get(K id) {
        return genericDao.find(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(E entity) {
        genericDao.add(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(E entity) {
        genericDao.update(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(E entity) {
        genericDao.remove(entity);
    }
}