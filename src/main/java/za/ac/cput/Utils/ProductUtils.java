package za.ac.cput.Utils;

import java.util.UUID;

public class ProductUtils {
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
    public static boolean isValid(String obj){
        return !obj.isEmpty() || !obj.isBlank();
    }
    public static boolean isValid(Float obj){
        return !(obj == null);
    }
    public static boolean isValid(Boolean obj){
        return !(obj == null);
    }
}
