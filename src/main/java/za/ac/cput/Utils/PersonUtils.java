package za.ac.cput.Utils;
/*
    Admin.java
    Admin Model class
    Author: Logan Kalib Coghill 221534067
    Date: 19 March 2024
*/
public class PersonUtils {
    public static boolean isValid(String obj){
        return !obj.isEmpty() || !obj.isBlank();
    }
    public static boolean isValid(Long obj){
        return !(obj == null);
    }
}
