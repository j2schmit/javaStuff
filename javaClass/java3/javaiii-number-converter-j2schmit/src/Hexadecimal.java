
public class Hexadecimal {

    public static String convertToDecimal(String hexadecimal) {
        hexadecimal = hexadecimal.toUpperCase();
        String hexValues = "0123456789ABCDEF";
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++) {
            char hex = hexadecimal.charAt(i);
            int index = hexValues.indexOf(hex);
            decimal = 16*decimal + index;
        }

        return Integer.toString(decimal);
    }

    public static String convertToBinary(String hexadecimal) {
        String decimal = Hexadecimal.convertToDecimal(hexadecimal);
        String binary = Decimal.convertToBinary(decimal);
        
        return binary;
    }
}
