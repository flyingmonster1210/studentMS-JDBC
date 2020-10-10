/**
 * Date: 2020/10/10
 * Author: Weijie Zeng
 * Reference: https://www.bilibili.com/video/BV1gt411G7Di?p=3
 */
package com.weijiez.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {
        // in project structure, dependencies add lib to project
        // and then launch the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("successfully launch the driver");

            // connect to database
            // connection is the object connecting to database
            // url: using database data via port 3306 with timezone = UTC
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/data?serverTimezone=UTC", "root", "1120822766");
            System.out.println("successfully connect to the database");

            // write SQL statements
            // use executeQuery() to do searching, and return result set
            // use executeUpdate() to change data
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM info;");
            while(resultSet.next()) {
                System.out.print(resultSet.getInt("id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILURE: unsuccessfully launch the driver, or unsuccessfully connect to the database");
        }
    }
}
