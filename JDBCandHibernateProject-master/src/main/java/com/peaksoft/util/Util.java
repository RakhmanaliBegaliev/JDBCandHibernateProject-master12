package com.peaksoft.util;

import com.peaksoft.dao.UserDaoHibernateImpl;
import com.peaksoft.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
//         реализуйте настройку соеденения с БД
    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Successfully connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    private static SessionFactory sessionFactory;
    static {
        try{
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://<your-host>:<your-port>/<your-dbname>");
            prop.setProperty("hibernate.connection.username", "<your-user>");
            prop.setProperty("hibernate.connection.password", "<your-password>");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

            sessionFactory = new AnnotationConfiguration()
                    .addPackage("com.concrete.persistance")
                    .addProperties(prop)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }



//    private static SessionFactory sessionFactory = buildSessionFactory();
//    private static SessionFactory buildSessionFactory() {
//        Configuration configuration = null;
//        try {
//            return new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
//                    .addAnnotatedClass(UserDaoHibernateImpl.class)
//                    .buildSessionFactory();
//        } catch (Exception e) {
//            throw e;
//        }
//    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}
