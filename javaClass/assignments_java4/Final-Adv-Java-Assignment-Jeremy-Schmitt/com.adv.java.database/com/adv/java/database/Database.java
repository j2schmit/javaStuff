package com.adv.java.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    protected Connection connection;

    public Database(String url) throws SQLException {
        System.out.println("Creating & opening database connection.\n");
        this.connection = DriverManager.getConnection(url);
    }

    public Connection getConnection() {
        return connection;
    }
}
