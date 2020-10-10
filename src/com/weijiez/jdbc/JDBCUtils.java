package com.weijiez.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static String driver, url, username, password;

    // initialize this static block only once
    static{
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p = new Properties();
        try {
            p.load(resourceAsStream);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            // launch MySQL driver
            Class.forName(driver);
            System.out.println("successfully to get driver info");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILURE: unsuccessfully to get driver info");
        }
    }

    // to get object for connection
    public static Connection getConnection() {
        try {
            System.out.println("successfully connect to the database");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("FAILURE: unsuccessfully connect to the database");
        }
        return null;
    }
}
