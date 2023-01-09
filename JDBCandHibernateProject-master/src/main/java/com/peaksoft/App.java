package com.peaksoft;


import com.peaksoft.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class App {
    public static void main(String[] args) {

        // реализуйте алгоритм здесь
        createUsersTable();
    }
    public static void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXIST users(" +
                "id BIGSERIAL PRIMARY KEY," +
                "name VARCHAR(50)," +
                "last_name VARCHAR (50)," +
                "age SMALLINT);";
        Session session = Util.createsessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery(SQL).executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
