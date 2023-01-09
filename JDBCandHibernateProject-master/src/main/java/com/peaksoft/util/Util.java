package com.peaksoft.util;

import com.peaksoft.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;


public class Util {
    //         реализуйте настройку соеденения с БД
//    private static String URL = "jdbc:postgresql://localhost:5432/postgres";
//    private static String USERNAME = "postgres";
//    private static String PASSWORD = "postgres";
//
//    public static Connection connection() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            System.out.println("Successfully connected");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }

    private static final SessionFactory sessionFactory = createsessionFactory();

    public static SessionFactory createsessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5433/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "postgres");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }

    public static EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("peaksoft");
    }
}
