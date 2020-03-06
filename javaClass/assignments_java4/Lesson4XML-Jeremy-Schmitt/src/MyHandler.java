import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
    boolean serialElement = false;
    boolean visibleStringElement = false;
    boolean unsignedElement = false;
    String serial;
    String visibleString;
    String unsigned;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (qName.equals("serial")) {
            serialElement = true;
        } else if (qName.equals("visible-string")) {
            visibleStringElement = true;
        } else if (qName.equals("unsigned")) {
            unsignedElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {};

    @Override
    public void characters(char[] ch, int start, int length) {
        if (serialElement) {
            serial = new String(ch, start, length);
            serialElement = false;
        } else if (visibleStringElement) {
            visibleString = new String(ch, start, length);
            visibleStringElement = false;
        } else if (unsignedElement) {
            unsigned = new String(ch, start, length);
            unsignedElement = false;
            PrettyPrint.prettyPrint(serial, visibleString, unsigned);
        }
    }
}
