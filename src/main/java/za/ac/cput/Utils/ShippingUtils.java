package za.ac.cput.Utils;

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

