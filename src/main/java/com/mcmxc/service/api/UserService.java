package com.mcmxc.service.api;

import com.mcmxc.entities.User;

public interface UserService extends GenericService<User,Integer>{

    User findUserByUsername(String username);

    void addDispathcer(User user);

}
