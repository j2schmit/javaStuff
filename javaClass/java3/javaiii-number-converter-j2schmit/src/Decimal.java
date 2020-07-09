
public class Decimal {

    public static String convertToBinary(String decimal) {
        String binary = "";
        int value = Integer.parseInt(decimal);
        int remainder;
        while (value > 0) {
            remainder = value % 2;
            value = value / 2;
            binary = Integer.toString(remainder) + binary;
        }

        return binary;
    }

    public static String convertToHexadecimal(String decimal) {
        String hexadecimal = "";
        String hexValues = "0123456789ABCDEF";
        int value = Integer.parseInt(decimal);
        int remainder;
        while (value > 0) {
            remainder = value % 16;
            value = value / 16;
            hexadecimal = hexValues.charAt(remainder) + hexadecimal;
        }

        return hexadecimal;
    }
}
