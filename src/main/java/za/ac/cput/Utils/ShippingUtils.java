package za.ac.cput.Utils;
/*
    ShippingUtils.java
    ShippingUtils class
    Author: Uzair Rabin 221013245
    Date: 26 March 2024
*/

import java.util.UUID;

public class ShippingUtils {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty())
            return true;
        return false;
    }

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}

