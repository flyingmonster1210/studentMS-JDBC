package com.weijiez.dao;

import com.weijiez.jdbc.JDBCUtils;
import com.weijiez.user.User;

import java.sql.*;

public class UserDao_Imp implements UserDao{
    private final String SQL_USER_LOGIN = "SELECT type FROM user WHERE username = ? AND password = ?";
    private final String SQL_USER_INSERT = "INSERT INTO user VALUES(id, ?, ?, ?)";

    @Override
    public int login(User user) {
        // create connection
        Connection connection = JDBCUtils.getConnection();
        // create statement
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_USER_LOGIN);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                return resultSet.getInt("type");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // execute SQL statements
        return -1;
    }

    @Override
    public boolean insert(User user) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_USER_INSERT);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, Integer.toString(user.getType()));
            int i = preparedStatement.executeUpdate();
            if(i > 0) return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(String username) {
        return false;
    }

    @Override
    public boolean update(String username) {
        return false;
    }

    @Override
    public User select(String username) {
        return null;
    }
}
