public class ArrayCustomUtils {
    // String Array utils

    public static Boolean checkArrayContains(String[] array, String value) {
        for (String v: array) {
            if (v!= null) {
                if (v.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean checkAllNotNull(String[] array) {
        for (String value: array) {
            if (value == null) {
                return false;
            }
        }
        return true;
    }

}
