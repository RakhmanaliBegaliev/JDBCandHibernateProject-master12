package com.peaksoft;


import com.peaksoft.dao.UserDao;
import com.peaksoft.dao.UserDaoJdbcImpl;
import com.peaksoft.model.User;
import com.peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        UserDao  u= new UserDaoJdbcImpl();
        u.saveUser("Bek","Isman",(byte) 15);
        System.out.println(u.getAllUsers());
        // реализуйте алгоритм здесь
    }



}
