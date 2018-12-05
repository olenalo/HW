/**
 * HW6 by OPersian.
 *
 * Count symmetries of digital clocks time.
 */

public class DigitalClocksSymmetry {

    private static String getFormattedTimePart(int hours) {
        if (hours < 10) {
            return "0" + hours;
        } else {
            return String.valueOf(hours);
        }
    }

    private static boolean checkIfMirrored(String hours, String minutes) {
        // Just a check
        if (!(hours.length() == 2 && minutes.length() == 2)) {
            return false;
        }
        return hours.charAt(0) == minutes.charAt(1) && hours.charAt(1) == minutes.charAt(0);
    }

    public static void main(String[] args) {

        String hours;
        String minutes;
        int symmetriesCount = 0;

        for (int i = 0; i < 24; i++) {
            hours = getFormattedTimePart(i);
            for (int j = 0; j < 60; j++) {
                minutes = getFormattedTimePart(j);
                if (checkIfMirrored(hours, minutes)) {
                    System.out.println("Symmetric combination: " + hours + ":" + minutes);
                    symmetriesCount++;
                }
            }
        }
        System.out.println("\n");
        System.out.println(symmetriesCount + " symmetric combinations occurred.");
    }
}
