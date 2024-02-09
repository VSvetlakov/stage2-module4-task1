package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Properties props = new Properties();
        try {
            props.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));

            String driver   = props.getProperty("jdbc_driver");
            String name     = props.getProperty("user");
            String password = props.getProperty("password");
            String url      = props.getProperty("db_url");

            Class.forName(driver) ;

            return DriverManager.getConnection(url, name, password);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

