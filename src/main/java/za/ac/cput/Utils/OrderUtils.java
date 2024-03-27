package za.ac.cput.Utils;

import java.util.List;
import java.util.UUID;

public class OrderUtils {

    // generate a unique ID
    private static String generateID() {
        return UUID.randomUUID().toString();
    }

    // validate input
    private static boolean validateInput(List<Product> products, Shipping shippingID, Payment paymentID, Customer customerID, float total, String orderNote) {

        if (products != null && !products.isEmpty() && shippingID != null && paymentID != null && customerID != null && total >= 0) {
            return true; // Input is valid
        } else {
            return false; // Input is not valid
        }
    }
}
