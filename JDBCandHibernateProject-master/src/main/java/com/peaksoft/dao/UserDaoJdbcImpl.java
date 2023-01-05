package com.peaksoft.dao;


import com.peaksoft.model.User;
import com.peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users1(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR (128) NOT NULL," +
                "lastName VARCHAR (128) NOT NULL," +
                "age INT NOT NULL);";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE users1";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO users1 (name, lastName, age) VALUES (?,?,?)";
        try (Connection connection = Util.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String SQL = " DELETE FROM users1 WHERE id = ?";
        User user = new User();
        try (Connection connection = Util.connection();
             PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        String SQL = "SELECT * FROM users1";
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {
        String SQL = "TRUNCATE TABLE users1";
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}