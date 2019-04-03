package com.mcmxc.dao.imp;


import com.mcmxc.dao.DaoException;
import com.mcmxc.dao.api.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


@Repository
public abstract class GenericDaoImp<E, K extends Serializable> implements GenericDao<E, K> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDaoImp.class);

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<? extends E> daoType;

    public GenericDaoImp() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }


    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void add(E entity) {
        currentSession().save(entity);
        logger.info("Entity successfully added. Entity details: " + entity.toString());
    }

    @Override
    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
        logger.info("Entity successfully updated. Entity details: " + entity.toString());
    }

    @Override
    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
        logger.info("Entity successfully updated. Entity details: " + entity.toString());
    }

    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
        logger.info("Entity successfully removed. Entity details: " + entity.toString());
    }

    @Override
    public E find(K key) {
        return currentSession().get(daoType, key);

    }

    @Override
    public List<E> getAll() throws DaoException{

        //return currentSession().createQuery("from " + daoType.getName()).getResultList();
        try {
            // unchecked conversion to conform to List<T>
            @SuppressWarnings("unchecked")
            List<E> allEntities = currentSession().createQuery("from " + daoType.getName())
                    .getResultList();

            return allEntities;
        } catch (Exception e) {
            logger.warn("Failed to FindAll entities for: " + daoType.getName()
                    + ". Exception msg: " + e.getMessage());
            throw new DaoException(e);
        }
    }
}

