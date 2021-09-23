package bank;

import java.util.concurrent.ThreadLocalRandom;

public class Tools {

    public static String isActiveToString(boolean active) {
        String result = "Inactive";
        if (active) {
            result = "Active";
        }
        return result;
    }

    public static String Pad(String string, int length, String pad, boolean leftPad) {
        String pillow = "";

        // Sets the size of the string
        if (length > string.length() ) {
            pillow = pad.repeat(length - string.length()) ;
        }
        else {
            string = string.substring(0, length - 1) + '|';
        }

        // If the string is shorter, then it requires a pillow.
        // The pillow will be on the right or left sides, according to this param
        if (leftPad) {
            return string + pillow;
        }
        else {
            return pillow + string;
        }
    }

    public static String getRandomNumberXpositions(int x) {
        StringBuilder id = new StringBuilder(8);
        int randomNum;
        for (int i = 0; i < x; i++) {
            id.append(ThreadLocalRandom.current().nextInt(0, 9));
        }
        return id.toString();
    }


}
