package com.mcmxc.service.api;


import com.mcmxc.service.exceprions.LogiwebServiceException;

import java.util.List;

public interface GenericService<E, K> {
    public void saveOrUpdate(E entity);
    public List<E> getAll()throws LogiwebServiceException;
    public E get(K id);
    public void add(E entity);
    public void update(E entity);
    public void remove(E entity);
}
