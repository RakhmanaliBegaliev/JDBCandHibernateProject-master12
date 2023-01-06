package com.peaksoft.dao;



import com.peaksoft.model.User;
import com.peaksoft.util.Util;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
    Session session = Util..openSession();
    session.beginTransaction();
        Query query = session.createQuery("CREAT TABLE users");
        query.executeUpdate();
    session.getTransaction().commit();
    session.close();
        System.out.println("Successfully created table users");
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
    Session session = Util.getSessionFactory().openSession();
    session.beginTransaction();

    }

    @Override
    public void removeUserById(long id) {
    Session session = Util.getSessionFactory().openSession();
    session.beginTransaction();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
