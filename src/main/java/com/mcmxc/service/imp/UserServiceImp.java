package com.mcmxc.service.imp;

import com.mcmxc.dao.api.GenericDao;
import com.mcmxc.dao.api.UserDao;
import com.mcmxc.entities.User;
import com.mcmxc.entities.enums.UserRole;
import com.mcmxc.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp extends GenericServiceImp<User, Integer>
        implements UserService {


    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImp() {

    }

    @Autowired
    public UserServiceImp(
            @Qualifier("userDaoImp") GenericDao<User, Integer> genericDao) {
        super(genericDao);
        this.userDao = (UserDao) genericDao;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.saveOrUpdate(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.saveOrUpdate(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.add(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addDispathcer(User user) {
        user.setRole(UserRole.ROLE_DISPATCHER);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.add(user);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

}
