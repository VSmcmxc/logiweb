package com.mcmxc.dao.imp;

import com.mcmxc.dao.api.UserDao;
import com.mcmxc.entities.User;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImp extends GenericDaoImp<User, Integer> implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImp.class);

    @Override
    public User findUserByUsername(String userName) {
            Query query = currentSession().createQuery(
                    "from User " +
                            "where userName=:userName");
            query.setParameter("userName", userName);
            logger.info("User successfully loaded. User details: " + userName);
            return (User) query.uniqueResult();
    }

}
