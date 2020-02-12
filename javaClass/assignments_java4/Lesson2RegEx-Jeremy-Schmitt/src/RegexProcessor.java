import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  This class processes creates an object that matches regex patterns one line at a time
 *  and stores matches in an ArrayList.
 *
 *  NOTE: If performance were a concern here, then I would modify this class to take a file as
 *  an argument. This would allow for Matcher to be instantiated only once, and it could match multiple groups.
 */
public class RegexProcessor {
    //Initialize Lists to hold matches
    private ArrayList<String> panIds = new ArrayList<String>();
    private ArrayList<String> macAddresses = new ArrayList<String>();
    private ArrayList<String> rfRssiMs = new ArrayList<String>();

    //Define patterns to be matched
    private final String panIdPatternString = "(^PANID\\s+=\\s+[0-9a-f]+[a-d]+)";
    private final String macAddressPatternString = "(000[0-9]+[a-f]+[0-9]+[a-f]+[0-9]*)";
    private final String rfRssiMPatternString = "(-[0-9]+\\.[0-9]+)";

    private Pattern panIdPattern = Pattern.compile(panIdPatternString);
    private Pattern macAddressPattern = Pattern.compile(macAddressPatternString);
    private Pattern rfRssiMPattern = Pattern.compile(rfRssiMPatternString);

    public RegexProcessor(){}

    public void processLine(String line) {

        Matcher panIdMatcher = panIdPattern.matcher(line);
        if (panIdMatcher.find()) {panIds.add(panIdMatcher.group(1));}

        Matcher macAddressMatcher = macAddressPattern.matcher(line);
        if (macAddressMatcher.find()) {macAddresses.add(macAddressMatcher.group(1));}

        Matcher rfRssiMMatcher = rfRssiMPattern.matcher(line);
        if (rfRssiMMatcher.find()) {rfRssiMs.add(rfRssiMMatcher.group(1));}
    }

    public ArrayList<String> getPanIds() {
        return panIds;
    }

    public ArrayList<String> getMacAddresses() {
        return macAddresses;
    }

    public ArrayList<String> getRfRssiMs() {
        return rfRssiMs;
    }
}
