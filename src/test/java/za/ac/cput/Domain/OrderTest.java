package za.ac.cput.Domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    // Test for object equality
    @Test
    void testObjectEquality() {
        Order order1 = createOrder1();
        Order order2 = createOrder1();
        assertEquals(order1, order2);
    }

    // Test for object identity
    @Test
    void testObjectIdentity() {
        Order order1 = createOrder1();
        Order order2 = order1;
        assertSame(order1, order2);
    }

    // Failing test
    @Test
    void failingTest() {
        assertFalse(true, "This test intentionally fails");
    }

    // Test for performance with a timeout
    @Test
    @Timeout(1) // Specifies the maximum time this test can take
    void testPerformance() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            products.add(new Product.Builder()
                    .setName("Brownies " + i)
                    .setPrice(10.0)
                    .build());
        }

        //  time-consuming operation
        for (int i = 0; i < 1000000; i++) {
            System.out.println("Processing product: " + products.get(i).getName());
        }
    }

    // Helper method to create sample order 1 with cake products
    private Order createOrder1() {
        List<Product> products = List.of(
                new Product.Builder()
                        .setName("Chocolate Cake")
                        .setProductId("P001")
                        .setPrice(150.0f)
                        .setQuantity(1)
                        .setDescription("Delicious chocolate cake")
                        .setIngredients("Chocolate")
                        .setAvailability(true)
                        .build(),
                new Product.Builder()
                        .setName("Vanilla Cake")
                        .setProductId("P002")
                        .setPrice(120.0f)
                        .setQuantity(1)
                        .setDescription("Classic vanilla cake")
                        .setIngredients("Vanilla")
                        .setAvailability(true)
                        .build()
        );

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
                .setCustomerId("C001")
                .build();

        return new Order.Builder()
                .orderID("O001")
                .products(products)
                .shippingID(shipping)
                .paymentID(payment)
                .customerID(customer)
                .total(270.0f)
                .orderNote("Gluten free")
                .build();
    }

    // Helper method to create sample order 2 with cake products
    private Order createOrder2() {
        List<Product> products = List.of(
                new Product.Builder()
                        .setName("Red Velvet Cake")
                        .setProductId("P003")
                        .setPrice(180.0f)
                        .setQuantity(1)
                        .setDescription("Rich and moist red velvet cake")
                        .setIngredients("Red Velvet")
                        .setAvailability(true)
                        .build(),
                new Product.Builder()
                        .setName("Carrot Cake")
                        .setProductId("P004")
                        .setPrice(200.0f)
                        .setQuantity(1)
                        .setDescription("Delicious carrot cake with cream cheese frosting")
                        .setIngredients("Carrot")
                        .setAvailability(true)
                        .build()
        );

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

        return new Order.Builder()
                .orderID("O002")
                .products(products)
                .shippingID(shipping)
                .paymentID(payment)
                .customerID(customer)
                .total(380.0f)
                .orderNote("Please expedite delivery")
                .build();
    }
}