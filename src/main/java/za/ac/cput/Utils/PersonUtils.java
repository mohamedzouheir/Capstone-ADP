package za.ac.cput.Utils;

public class PersonUtils {
    public static boolean isValid(String obj){
        return !obj.isEmpty() || !obj.isBlank();
    }
    public static boolean isValid(Long obj){
        return !(obj == null);
    }
}
