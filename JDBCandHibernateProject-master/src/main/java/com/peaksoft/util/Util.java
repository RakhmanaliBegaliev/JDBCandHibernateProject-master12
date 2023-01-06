package com.peaksoft.util;

import com.peaksoft.dao.UserDaoJdbcImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    //     реализуйте настройку соеденения с БД
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
    Properties prop= new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:mysql://<your-host>:<your-port>/<your-dbname>");

    //You can use any database you want, I had it configured for Postgres
        prop.setProperty("dialect", "org.hibernate.dialect.PostgresSQL");

        prop.setProperty("hibernate.connection.username", "<your-user>");
        prop.setProperty("hibernate.connection.password", "<your-password>");
        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("show_sql", true); //If you wish to see the generated sql query

    SessionFactory sessionFactory = new Configuration().addProperties(prop).buildSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
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
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public void close() {
//        sessionFactory.close();
//    }
//}close
