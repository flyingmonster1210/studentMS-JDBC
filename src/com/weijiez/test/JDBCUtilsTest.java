package com.weijiez.test;

import com.weijiez.jdbc.JDBCUtils;
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
}
