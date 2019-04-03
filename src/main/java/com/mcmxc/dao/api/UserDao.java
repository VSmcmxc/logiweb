package com.mcmxc.dao.api;

import com.mcmxc.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
    public User findUserByUsername(String username);

}
