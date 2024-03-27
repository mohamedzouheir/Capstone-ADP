package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.*;
import za.ac.cput.Factory.OrderFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

    @Test
    public void testCreateOrder() {
        // Create sample data for testing
        List<Product> products = new ArrayList<>();
        products.add(new Product.Builder()
                .setName("Chocolate Cake")
                .setProductId("P001")
                .setPrice(150.0f)
                .setQuantity(1)
                .setDescription("Delicious chocolate cake")
                .setIngredients("Chocolate")
                .setAvailability(true)
                .build());
        products.add(new Product.Builder()
                .setName("Vanilla Cake")
                .setProductId("P002")
                .setPrice(120.0f)
                .setQuantity(1)
                .setDescription("Classic vanilla cake")
                .setIngredients("Vanilla")
                .setAvailability(true)
                .build());

        Shipping shipping = new Shipping.Builder()
                .setShippingID("S001")
                .setAddress1("123 Main St")
                .setCity("Cape Town")
                .setState("Western Cape")
                .setPostalCode(8000)
                .setTrackStatus("Shipped")
                .build();

        Payment payment = new Payment.Builder()
                .setPaymentId("PA001")
                .setPayMethod("Credit Card")
                .setAmount(270.0)
                .setPayDate(new Date())
                .build();

        Customer customer = new Customer.Builder()
                .setIdentity(new Person.Builder()
                        .setPhoneNumber("0829908216")
                        .setFirstName("Aaniquah")
                        .setLastName("Dicks")
                        .setEmail("dicksaaniquah@gmail.com")
                        .setPassword("Fat&1")
                        .build())
                .setCustomerId("C002")
                .build();


        float total = 270.0f;
        String orderNote = "Gluten free";

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
        products.add(new Product.Builder()
                .setName("Red Velvet Cake")
                .setProductId("P003")
                .setPrice(180.0f)
                .setQuantity(1)
                .setDescription("Rich and moist red velvet cake")
                .setIngredients("Red Velvet")
                .setAvailability(true)
                .build());
        products.add(new Product.Builder()
                .setName("Carrot Cake")
                .setProductId("P004")
                .setPrice(200.0f)
                .setQuantity(1)
                .setDescription("Delicious carrot cake with cream cheese frosting")
                .setIngredients("Carrot")
                .setAvailability(true)
                .build());

        Shipping shipping = new Shipping.Builder()
                .setShippingID("S002")
                .setAddress1("456 Oak St")
                .setCity("Johannesburg")
                .setState("Gauteng")
                .setPostalCode(2000)
                .setTrackStatus("In Transit")
                .build();

        Payment payment = new Payment.Builder()
                .setPaymentId("PA002")
                .setPayMethod("Debit Card")
                .setAmount(380.0)
                .setPayDate(new Date())
                .build();

        Customer customer = new Customer.Builder()
                .setIdentity(new Person.Builder()
                        .setPhoneNumber("0829908216")
                        .setFirstName("Aaniquah")
                        .setLastName("Dicks")
                        .setEmail("dicksaaniquah@gmail.com")
                        .setPassword("Fat&1")
                        .build())
                .setCustomerId("C002")
                .build();


        float total = 380.0f;

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
