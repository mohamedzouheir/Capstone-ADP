package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.*;
import za.ac.cput.Factory.OrderFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

    @Test
    public void testCreateOrder() {
        // Create sample data for testing
        List<Product> products = new ArrayList<>();
        products.add(new Product("P001", "Red velvet cake", 100.0f));
        products.add(new Product("P002", "Vanilla cake", 150.0f));

        Shipping shipping = new Shipping("S001", "Standard Shipping");
        Payment payment = new Payment("PA001", "Credit Card");
        Customer customer = new Customer("C001", "John Doe");

        float total = 250.0f;
        String orderNote = "Please expedite delivery";

        // Call the createOrder method of the OrderFactory
        Order order = OrderFactory.createOrder(products, shipping, payment, customer, total, orderNote);

        // Verify that the Order object is created correctly
        assertNotNull(order);
        assertEquals(products, order.getProducts());
        assertEquals(shipping, order.getShippingID());
        assertEquals(payment, order.getPaymentID());
        assertEquals(customer, order.getCustomerID());
        assertEquals(total, order.getTotal());
        assertEquals(orderNote, order.getOrderNote());
    }

    @Test
    public void testCreateOrderWithID() {
        // Create sample data for testing
        String orderID = "O001";
        List<Product> products = new ArrayList<>();
        products.add(new Product("P001", "Product 1", 100.0f));
        products.add(new Product("P002", "Product 2", 150.0f));

        Shipping shipping = new Shipping("S001", "Standard Shipping");
        Payment payment = new Payment("PA001", "Credit Card");
        Customer customer = new Customer("C001", "John Doe");

        float total = 250.0f;

        // Call the createOrderWithID method of the OrderFactory
        Order order = OrderFactory.createOrderWithID(orderID, products, shipping, payment, customer, total);

        // Verify that the Order object is created correctly
        assertNotNull(order);
        assertEquals(orderID, order.getOrderID());
        assertEquals(products, order.getProducts());
        assertEquals(shipping, order.getShippingID());
        assertEquals(payment, order.getPaymentID());
        assertEquals(customer, order.getCustomerID());
        assertEquals(total, order.getTotal());
        assertNull(order.getOrderNote()); // Order note should be null since not provided
    }
}