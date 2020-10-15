package com.weijiez.dao;

import com.weijiez.jdbc.JDBCUtils;
import com.weijiez.user.User;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

public class UserDao_Imp implements UserDao{
    private static final String SQL_USER_UPDATE = "UPDATE `user` SET password = ? WHERE username = ?;";
    private static final String SQL_USER_LOGIN = "SELECT type FROM user WHERE username = ? AND password = ?;";
    private static final String SQL_USER_INSERT = "INSERT INTO user VALUES(id, ?, ?, 2);";
    private static final String SQL_USER_DELETE = "DELETE FROM user WHERE username = ?;";
    private static final String SQL_USER_SELECT = "SELECT * FROM `user` WHERE username = ?;";

    @Override
    public int login(User user) {
        // create connection
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        // create statement
        try {
            preparedStatement = connection.prepareStatement(SQL_USER_LOGIN);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                return resultSet.getInt("type");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
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
//            preparedStatement.setString(3, Integer.toString(user.getType()));
            int i = preparedStatement.executeUpdate();
            if(i > 0) return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }

        return false;
    }

    @Override
    public boolean delete(String username) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_USER_DELETE);
            preparedStatement.setString(1, username);
            int i = preparedStatement.executeUpdate();
            if(i > 0) return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_USER_UPDATE);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(1, user.getPassword());
            int i = preparedStatement.executeUpdate();
            if(i > 0) return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, null);
        }
        return false;
    }

    @Override
    public User select(String username) {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_USER_SELECT);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("username");
                String pass = resultSet.getString("password");
                int id = resultSet.getInt("id");
                int type = resultSet.getInt("type");
                return new User(id, name, pass, type);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        
        return null;
    }
}
