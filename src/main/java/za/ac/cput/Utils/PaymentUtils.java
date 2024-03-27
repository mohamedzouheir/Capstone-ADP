package za.ac.cput.Utils;
/*
    Payment Util Class
    Author: Sheldon Luke Arendse 221190384
    Date: 21 March 2024
*/

import za.ac.cput.Domain.Payment;

import java.util.UUID;

public class PaymentUtils {
    public static Boolean isValid(Payment obj) {
        return obj != null;
    }

    public static Boolean isNotBlankOrEmpty(String s) {
        return !s.isEmpty() || !s.isBlank();
    }

    public static Boolean isNullOrEmpty(String t) {
        if (t == null || t.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
