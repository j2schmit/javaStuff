import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class Lesson4XML {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        String xmlFile = "JobResult_UCSDExt.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(xmlFile);

        System.out.println("Results of XML Parsing using DOM Parser:");
        domParser(doc);

        System.out.println("Results of XML Parsing using SAX Parser:");
        saxParser(xmlFile);

        System.out.println("Results of XML Parsing using XPath:");
        xPathParser(doc);

        System.out.println("All done!");
    }

    public static void domParser(Document doc) {
        Element root = doc.getDocumentElement();
        String serial = root.getFirstChild().getTextContent();
        NodeList children = root.getChildNodes();
        String visibleString = children.item(1).getFirstChild().getTextContent();
        String unsigned = children.item(2).getFirstChild().getFirstChild().getTextContent();
        PrettyPrint.prettyPrint(serial, visibleString, unsigned);
    }

    public static void saxParser(String xmlFile) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File(xmlFile), myHandler);
    }

    public static void xPathParser(Document doc) throws XPathExpressionException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        String serial = xPath.evaluate("/jobresult/serial/text()", doc);
        String visibleString = xPath.evaluate("/jobresult/data/visible-string/text()", doc);
        String unsigned = xPath.evaluate("/jobresult/data[2]/structure/unsigned/text()", doc);
        PrettyPrint.prettyPrint(serial, visibleString, unsigned);
    }

}
