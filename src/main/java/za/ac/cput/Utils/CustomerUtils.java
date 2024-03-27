package za.ac.cput.Utils;

/*
CustomerUtils.Java
Customer Utils Class
Author: Aa'ishah Van Witt
Date: 26 March 2024
 */

import za.ac.cput.Domain.Order;
import za.ac.cput.Domain.Person;

import java.util.List;
import java.util.UUID;

public class CustomerUtils {

    public static Boolean isValid(Person obj) {
        return obj != null;
    }

    public static Boolean isValid(String obj) {
        return !obj.isEmpty() || !obj.isBlank();
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
