pacakage com.adv.java.final.application;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import com.adv.java.networking.streamurl.StreamUrl;
import com.adv.java.iostream.IOStreaml;
import com.adv.java.restaurant.RestaurantXMLParser;
import com.adv.java.restaurant.Restaurant;
import com.adv.java.restaurant.RestaurantDatabase;

/**
 * This is the final project for Java 4: Advanced Java via UCSD Extension.
 * Multiple modules have been created and used interactively to:
 *
 * 1) Read in a XML file of data on restaurants in Baltimore from https://data.gov
 *      (see https://catalog.data.gov/dataset/restaurants-15baa )
 * 2) The file is written to a text XML file.
 * 3) An XML parser is applied to create Restaurant objects for each restaurant in the XML file.
 * 4) A JDBC Derby database is created, and each restaurant is entered as a new row.
 * 5) Various queries are conducted to answer questions about restaurants in Baltimore.
 *
 * The following modules were created:
 * 1) com.adv.java.final.application (the final project is executed via the main method in Application.java)
 * 2) com.adv.java.networking (this is used to access the URL from https://data.gov)
 * 3) com.adv.java.iostream (this used to write to file)
 * 4) com.adv.java.xml (this is used to parse the XML)
 * 5) com.adv.java.database (this is used for database operations)
 * 6) com.adv.java.restaurant (this is used for various restaurant-related classes)
 * 
 */

public class Application {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, SQLException, InterruptedException {

        System.out.println("\nWe will be exploring restaurants in Baltimore by accessing a XML file from https://data.gov, " +
                "parsing the XML, creating a database,\nand conducting queries to discover Epicurean delights!\n");
        TimeUnit.SECONDS.sleep(3);

        String xmlFile = "data.xml";
        String url = "https://data.baltimorecity.gov/api/views/k5ry-ef3g/rows.xml";

        StreamUrl urlStream = new StreamUrl(url);

        IOStream.xMLInputStreamToFile(urlStream.getUrlInputStream(), xmlFile);

        RestaurantXMLParser xmlParser = new RestaurantXMLParser(xmlFile);
        Restaurant[] restaurants = xmlParser.parseXML(1);

        String dbUrl = "jdbc:derby:Restaurants;create=true";
        RestaurantDatabase restaurantDB = new RestaurantDatabase(dbUrl);
        //restaurantDB.dropTable();
        String tableName = "RESTAURANTS";
        restaurantDB.createTable(tableName);
        restaurantDB.addRestaurants(restaurants);

        System.out.println("QUESTION: Where should Java programmers eat in Baltimore?");
        TimeUnit.SECONDS.sleep(2);
        String query = "SELECT * FROM " + tableName + " WHERE Name LIKE '%JAVA%'";
        restaurantDB.query(query);

        TimeUnit.SECONDS.sleep(3);
        System.out.println("QUESTION: How many sushi restaurants are in Baltimore?");
        TimeUnit.SECONDS.sleep(2);
        query = "SELECT COUNT(*) AS Sushi_Count FROM " + tableName + " WHERE Name LIKE '%SUSHI%'";
        restaurantDB.query(query);
        //String query =  "SELECT * FROM " + tableName + " WHERE Neighborhood NOT LIKE 'F%'";

        TimeUnit.SECONDS.sleep(3);
        System.out.println("QUESTION: What neighborhood has the most restaurants?");
        TimeUnit.SECONDS.sleep(2);
        query = "SELECT neighborhood, COUNT(neighborhood) AS Neighborhood_Count " +
        "FROM " + tableName +
        " GROUP BY neighborhood " +
        "ORDER BY Neighborhood_Count DESC FETCH FIRST 1 ROW ONLY";
        restaurantDB.query(query);

        TimeUnit.SECONDS.sleep(3);
        System.out.println("QUESTION: What neighborhood has the most sushi restaurants?");
        TimeUnit.SECONDS.sleep(2);
        query = "SELECT neighborhood, COUNT(neighborhood) AS Neighborhood_Count " +
                "FROM " + tableName + " WHERE Name LIKE '%SUSHI%'" +
                " GROUP BY neighborhood " +
                "ORDER BY Neighborhood_Count DESC FETCH FIRST 1 ROW ONLY";
        restaurantDB.query(query);

        TimeUnit.SECONDS.sleep(3);
        System.out.println("QUESTION: Where's the best Chinese food in Baltimore?");
        TimeUnit.SECONDS.sleep(2);
        query = "SELECT * FROM " + tableName + " WHERE Name LIKE '%#1 chinese%'";
        restaurantDB.query(query);

        restaurantDB.dropTable();
    }
}
