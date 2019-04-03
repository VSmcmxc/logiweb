/*
package com.mcmxc;


import com.mcmxc.dao.api.DriverDao;
import com.mcmxc.dao.imp.DriverDaoImp;
import com.mcmxc.entities.Driver;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ApplicationContext context=new ClassPathXmlApplicationContext("appconfig-data.xml");



        SessionFactory sessionFactory=context.getBean(SessionFactory.class);

        DriverDao personDAO = new DriverDaoImp(sessionFactory);





        for (Driver driver :personDAO.getAll()) {
            System.out.println(driver);
        }


        ((ClassPathXmlApplicationContext) context).close();
    }
}
*/
