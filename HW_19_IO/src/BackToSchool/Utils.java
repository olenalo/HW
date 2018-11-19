package BackToSchool;

import java.util.regex.Pattern;

public class Utils {
    private Utils(){
        throw new UnsupportedOperationException("This is util class");
    }

    public static void validate(int arg, int from, int to){
        double doubleArg = arg;
        validate(doubleArg, from, to);
    }

    public static void validate(double arg, int from, int to){
        if(arg < from || arg > to){
            throw new IllegalArgumentException("Invalid paraemter");
        }
    }

    public static void validateString(String regex, String idNumber) {
        if(!Pattern.matches(regex, idNumber)){
            throw new IllegalArgumentException("Incorrect id");
        }
    }
}
