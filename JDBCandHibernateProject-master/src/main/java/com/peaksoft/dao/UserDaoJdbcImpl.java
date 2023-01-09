//package com.peaksoft.dao;
//
//
//import com.peaksoft.model.User;
//import com.peaksoft.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJdbcImpl implements UserDao {
//
//    public UserDaoJdbcImpl() {
//
//    }
//
//    public void createUsersTable() {
//        String SQL = "CREATE TABLE IF NOT EXISTS users(" +
//                "id SERIAL PRIMARY KEY," +
//                "name VARCHAR (128) NOT NULL," +
//                "lastname VARCHAR (128) NOT NULL," +
//                "age SMALLINT NOT NULL);";
//        try (Connection connection = Util.connection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        String SQL = "DROP TABLE IF EXISTS users";
//        try (Connection connection = Util.connection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        String SQL = "INSERT INTO users(name, lastname, age) VALUES (?,?,?)";
//        try (Connection connection = Util.connection();
//             PreparedStatement statement = connection.prepareStatement(SQL)) {
//            statement.setString(1, name);
//            statement.setString(2, lastName);
//            statement.setByte(3, age);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        String SQL = " DELETE FROM users WHERE id = ?";
//        try (Connection connection = Util.connection();
//             PreparedStatement statement = connection.prepareStatement(SQL)) {
//            statement.setLong(1, id);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        String SQL = "SELECT * FROM users";
//        List<User> users = new ArrayList<>();
//        try (Connection connection = Util.connection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(SQL)) {
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastname"));
//                user.setAge(resultSet.getByte("age"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public void cleanUsersTable() {
//        String SQL = "TRUNCATE TABLE users";
//        try (Connection connection = Util.connection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}