package com.adv.java.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public abstract class AbstractXMLParser {

    protected Document doc;

    public AbstractXMLParser() {}

    public AbstractXMLParser(String file) throws ParserConfigurationException, IOException, SAXException {
        System.out.println("Creating Document from XML file:");
        System.out.println(file + "\n");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        doc = builder.parse(file);
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public abstract <T> T parseXML(int index);
}
