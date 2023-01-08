package com.peaksoft.dao;



import com.peaksoft.model.User;
import com.peaksoft.util.Util;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXIST users(" +
                "id BIGSERIAL PRIMARY KEY," +
                "name VARCHAR(50)," +
                "last_name VARCHAR (50)," +
                "age SMALLINT);";
        Session session = Util.getSessionFactory().openSession();
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

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.getTransaction();
        Query query = session.createQuery("DROP TABLE users");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully dropped table");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO users1 (name, lastName, age) VALUES (?,?,?)";
        Session session = Util.getSessionFactory().openSession();
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

    @Override
    public void removeUserById(long id) {
        //    Session session = Util.getSessionFactory().openSession();
//    session.beginTransaction();
//    User user = session.get(User.class, id);
//    session.delete(user);
//    session.getTransaction().commit();
//    session.close();
//        System.out.println("Successfully deleted " + user);
        String SQL = "DELETE FROM users WHERE id = ?";
        Session session = Util.getSessionFactory().openSession();
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

    @Override
    public List<User> getAllUsers() {
//        String SQL = "SELECT * FROM users";
//        List<User> users = new ArrayList<>();
//        try(ResultSet resultSet = se){
//        }
//    }
        return null;
    }

    @Override
    public void cleanUsersTable() {
        String SQL = "TRUNCATE TABLE users";
        Session session = Util.getSessionFactory().openSession();
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
