package com.adv.java.restaurant;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

import com.adv.java.xml.AbstractXMLParser;

public class RestaurantXMLParser extends AbstractXMLParser {

    public RestaurantXMLParser(String file) throws IOException, SAXException, ParserConfigurationException {
        super(file);
    }

    public Restaurant[] parseXML(int index) {
        System.out.println("Parsing restaurant info from Document.\n");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        NodeList rows = null;
        try {
            rows = (NodeList) xPath.evaluate("/response/row/row", doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        int numberOfRestaurants = rows.getLength();
        Restaurant[] restaurants = new Restaurant[numberOfRestaurants - 1];

        String name = null;
        int zipcode = 0;
        String neighborhood = null;
        for (int i = 1; i < numberOfRestaurants; i++) {
            try {
                name = xPath.evaluate("/response/row/row[" + i + "]/name/text()", doc);
                zipcode = Integer.parseInt(xPath.evaluate("/response/row/row[" + i + "]/zipcode/text()", doc));
                neighborhood = xPath.evaluate("/response/row/row[" + i + "]/neighborhood/text()", doc);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            restaurants[i-1] = new Restaurant(name, zipcode, neighborhood);
        }

        return restaurants;
    }

}
