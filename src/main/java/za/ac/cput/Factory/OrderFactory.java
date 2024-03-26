package za.ac.cput.Factory;
//Aaniquah Dicks,222641495
import java.util.List;
import java.util.UUID;

import za.ac.cput.Domain.*;
import za.ac.cput.Utils.OrderUtils;

public class OrderFactory {

    // Create Order with a generated ID
    public static Order createOrder(List<Product> products, Shipping shippingID, Payment paymentID, Customer customerID, float total, String orderNote) {
        String orderID = OrderUtils.generateID(); // Generate a unique order ID using OrderUtils

        if (OrderUtils.validateInput(products, shippingID, paymentID, customerID, total, orderNote)) {
            return new Order.Builder()
                    .orderID(orderID)
                    .products(products)
                    .shippingID(shippingID)
                    .paymentID(paymentID)
                    .customerID(customerID)
                    .total(total)
                    .orderNote(orderNote)
                    .build(); // Build and return the Order object
        } else {
            throw new IllegalArgumentException("Invalid input parameters for creating order.");
        }
    }

    //Create a new Order with no custom order note
    public static Order createOrderWithID(String orderID, List<Product> products, Shipping shippingID, Payment paymentID, Customer customerID, float total) {
        if (OrderUtils.validateInput(products, shippingID, paymentID, customerID, total, null)) {
            return new Order.Builder()
                    .orderID(orderID)
                    .products(products)
                    .shippingID(shippingID)
                    .paymentID(paymentID)
                    .customerID(customerID)
                    .total(total)
                    .build();
        } else {
            throw new IllegalArgumentException("Invalid input parameters for creating order.");
        }
    }
}






