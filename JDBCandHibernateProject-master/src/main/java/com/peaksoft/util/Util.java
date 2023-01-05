package com.peaksoft.util;

import com.peaksoft.dao.UserDaoHibernateImpl;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
//     реализуйте настройку соеденения с БД
    private static String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";

    public static Connection connection (){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Successfully connected");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }

    private static SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        Configuration configuration = null;
        try {
            return new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(UserDaoHibernateImpl.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw e;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}
