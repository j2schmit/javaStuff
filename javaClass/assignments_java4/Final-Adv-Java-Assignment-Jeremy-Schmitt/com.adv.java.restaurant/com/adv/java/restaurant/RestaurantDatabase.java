package com.adv.java.restaurant;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.adv.java.database.Database;

public class RestaurantDatabase extends Database{

    private Statement statement;
    private String tableName = "RESTAURANTS";

    public RestaurantDatabase(String url) throws SQLException {
        super(url);
        statement = connection.createStatement();
    }

    public void addRestaurants(Restaurant[] restaurants) throws SQLException {
        String addCmd = null;
        for (Restaurant restaurant : restaurants) {
            addCmd = "INSERT INTO " + tableName + " VALUES ('" + restaurant.getName() + "', "
                    + restaurant.getZipcode() + ", '" + restaurant.getNeighborhood() + "')";
            statement.executeUpdate(addCmd);
        }
    }

    public void createTable(String tableName) throws SQLException {
        this.tableName = tableName;
        System.out.println("Creating database table:");
        System.out.println(tableName + "\n");
        String createCmd = "CREATE TABLE " + tableName + " (Name VARCHAR(256), Zipcode INTEGER, Neighborhood VARCHAR(256))";
        statement.executeUpdate(createCmd);
    }

    public void query(String queryCmd) throws SQLException {
        // "SELECT * FROM " + tableName;
        System.out.println("QUERY: " + queryCmd + "\n");
        System.out.println("ANSWER:");
        ResultSet results = statement.executeQuery(queryCmd);
        ResultSetMetaData metaData = results.getMetaData();
        int columnsNumber = metaData.getColumnCount();
        while (results.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                String columnValue = results.getString(i);
                System.out.println(metaData.getColumnName(i) + ": " + columnValue);
            }
        }
        System.out.println("");
    }

    public void dropTable() throws SQLException {
        System.out.println("Removing table:");
        System.out.println(tableName);
        statement.executeUpdate("DROP TABLE " + tableName);
    }
}
