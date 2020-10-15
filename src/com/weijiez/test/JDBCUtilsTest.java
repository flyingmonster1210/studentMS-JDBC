package com.weijiez.test;

import com.weijiez.dao.UserDao_Imp;
import com.weijiez.jdbc.JDBCUtils;
import com.weijiez.user.User;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtilsTest {

    @Test
    public void jdbcConnectionTest() throws Exception {
        // connection tool
        Connection connection = JDBCUtils.getConnection();
        // statement = using this to write SQL statements
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM info");
        while(resultSet.next()) {
            System.out.print(resultSet.getInt("id") + " ");
            System.out.print(resultSet.getString("name") + " ");
            System.out.println(resultSet.getString("password"));
        }
    }

    @Test
    public void loginTest() throws Exception {
        UserDao_Imp userDao_imp = new UserDao_Imp();
        int type1 = userDao_imp.login(new User("jack", "jack"));
        int type2 = userDao_imp.login(new User("jack", "jack"));
        System.out.println(type1);
        System.out.println(type2);
    }
}
