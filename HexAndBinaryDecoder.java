import java.util.Scanner; // Github 1

public class HexAndBinaryDecoder {

    public static short hexCharDecode(char hexChar)
    {

        short decimal = ((short)(hexChar-55));

        if ((short)hexChar < 58)
        {
            decimal = (short)(hexChar - 48);
        }
        else if ((short)hexChar < 91 && (short)hexChar < 64)
        {
            decimal = (short)(hexChar - 55);
        }
        else if((short)hexChar < 123 && (short)hexChar > 96)
        {
            decimal = (short)(hexChar - 87);
        }
        return decimal;
    }

    public static long hexStringDecode(String hex) {

        hex = hex.toUpperCase();
        long decimal = 0;
        int power = hex.length();

        for (int index = 0; index < hex.length(); index++) {

            if (hex.charAt(0) == '0' && hex.charAt(1) == 'X' && index < 2) {
                index = 2;

            }

            if ((hex.charAt(0) == '0' && hex.charAt(1) == 'X')) {

                if ((int) hex.charAt(index) > 64) {
                    decimal += (((int) hex.charAt(index) - 55) * Math.pow(16, power - 3));
                    power--;
                } else {
                    decimal += (((int) hex.charAt(index) - 48) * Math.pow(16, power - 3));
                    power--;
                }

            } else {
                if ((int) hex.charAt(index) > 64) {
                    decimal += (((int) hex.charAt(index) - 55) * Math.pow(16, power - 1));
                    power--;
                } else {
                    decimal += (((int) hex.charAt(index) - 48) * Math.pow(16, power - 1));
                    power--;
                }
            }
        }
        return decimal;
    }

    public static long binaryStringDecode(String bin)
    {
        long decimal = 0;
        int power = bin.length() - 1;

        for (int index = 0; index < bin.length(); index++) {

            if (bin.charAt(0) == '0' && bin.charAt(1) == 'b' && index < 2) {

                index = 2;
            }

            if (bin.charAt(0) == '0' && bin.charAt(1) == 'b') {
                if (bin.charAt(index) == '0') {
                    decimal = decimal;
                } else
                    decimal += Math.pow(2, power - 2);
                power--;
            }
            else {
                if (bin.charAt(index) == '0') {
                    decimal = decimal;
                    power--;
                } else {
                    decimal += Math.pow(2, power);
                    power--;
                }
            }
        }
        return decimal;
    }


    public static void main(String[] args) {

        Scanner lab3 = new Scanner(System.in);

        String menu = "Choose an option:\n1. Decode a hex string.\n2. Decode a binary string.\n3. Convert binary to hex.\n4. Quit.";

        int menuOption = 0;
        String input;


        while (menuOption != 4) {

            System.out.println(menu);
            menuOption = lab3.nextInt();

            switch (menuOption) {
                case 1:
                    System.out.println("Please enter the hex string:");
                    input = lab3.next();
                    System.out.println( "Result:" + hexStringDecode(input));
                    break;
                case 2:
                    System.out.println("Please enter the binary string: ");
                    input = lab3.next();
                    System.out.println("Result:" + binaryStringDecode(input));
                    break;
                case 4:
                    System.out.println("Quitting program.");
                    System.exit(0);
                    break;


            }

        }
    }
}


