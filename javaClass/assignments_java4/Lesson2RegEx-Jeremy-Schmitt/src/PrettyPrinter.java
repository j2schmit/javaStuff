import java.util.*;

/**
 * This is simply a class to format and print the output as desired.
 *
 */

public class PrettyPrinter {

    private PrettyPrinter() {}

    public static void prettyPrintResults(RegexProcessor regexProcessor) {
        ArrayList<String> panIds = regexProcessor.getPanIds();
        System.out.println(String.format("- List of PAN IDs (Total of %d)", panIds.size()));
        printList(panIds);

        ArrayList<String> macAddresses = regexProcessor.getMacAddresses();
        System.out.println(String.format("- List of MAC Addresses (Total of %d)", macAddresses.size()));
        printList(macAddresses);

        ArrayList<String> rfRssiMs = regexProcessor.getRfRssiMs();
        System.out.println("- List of RF_RSSI_M values for each MAC address");
        for (int index = 0 ; index < macAddresses.size() ; index++) {
            System.out.println(macAddresses.get(index) + " " + rfRssiMs.get(index));
        }
    }

    private static void printList(ArrayList<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }



}
