
public class Binary {

    public static String convertToDecimal(String binary) {
        String binaryValues = "01";
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            char bin = binary.charAt(i);
            int index = binaryValues.indexOf(bin);
            decimal = 2*decimal + index;
        }

        return Integer.toString(decimal);
    }

    public static String convertToHexadecimal(String binary) {
        String decimal = Binary.convertToDecimal(binary);
        String hexadecimal = Decimal.convertToHexadecimal(decimal);

        return hexadecimal;
    }
}
