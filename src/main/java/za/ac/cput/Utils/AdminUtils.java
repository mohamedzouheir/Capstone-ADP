package za.ac.cput.Utils;

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
