package za.ac.cput.Utils;
/*
    Admin.java
    Admin Model class
    Author: Logan Kalib Coghill 221534067
    Date: 19 March 2024
*/
import za.ac.cput.Domain.Person;

import java.util.UUID;

public class AdminUtils {

    public static Boolean isValid(Person obj){
        return obj != null;
    }
    public static Boolean isValid(String obj){
        return !obj.isEmpty() || !obj.isBlank();
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
