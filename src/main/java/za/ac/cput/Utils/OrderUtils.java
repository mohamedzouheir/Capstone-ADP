package za.ac.cput.Utils;

import za.ac.cput.Domain.Customer;
import za.ac.cput.Domain.Payment;
import za.ac.cput.Domain.Product;
import za.ac.cput.Domain.Shipping;

import java.util.List;
import java.util.UUID;

public class OrderUtils {

    // generate a unique ID
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    // validate input
    public static boolean validateInput(List<Product> products, Shipping shippingID, Payment paymentID, Customer customerID, float total, String orderNote) {

        if (products != null && !products.isEmpty() && shippingID != null && paymentID != null && customerID != null && total >= 0) {
            return true; // Input is valid
        } else {
            return false; // Input is not valid
        }
    }
}
