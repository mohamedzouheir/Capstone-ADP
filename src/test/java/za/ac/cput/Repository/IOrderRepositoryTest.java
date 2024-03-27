package za.ac.cput.Repository;
//Aaniquah Dicks 222641495
import org.junit.jupiter.api.*;
import za.ac.cput.Domain.*;
import za.ac.cput.Domain.Order;
import za.ac.cput.Factory.OrderFactory;
import za.ac.cput.Repository.IOrderRepository;
import za.ac.cput.Repository.OrderRepositoryImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderRepositoryTest {
    private static IOrderRepository<Order, String> orderRepository = new OrderRepositoryImp();
    private static Order order;

    @BeforeAll
    static void setUp() {

            // Create a red velvet cake product
            Product redVelvetCake = new Product.Builder()
                    .setName("Red Velvet Cake")
                    .setProductId("P001")
                    .setPrice(270.0f)
                    .setQuantity(1)
                    .setDescription("Rich and moist red velvet cake")
                    .setIngredients("Red Velvet")
                    .setAvailability(true)
                    .build();

            // Create a list containing the red velvet cake product
            List<Product> products = new ArrayList<>();
            products.add(redVelvetCake);

            // Create a shipping object
            Shipping shipping = new Shipping.Builder()
                    .setShippingID("S001")
                    .setAddress1("123 Main St")
                    .setAddress2("Apt 101")
                    .setCity("Cape Town")
                    .setState("Western Cape")
                    .setPostalCode(8000)
                    .setTrackStatus("Shipped")
                    .build();

            // Create a payment object
            Payment payment = new Payment.Builder()
                    .setPaymentId("PA001")
                    .setPayMethod("Credit Card")
                    .setAmount(270.0)
                    .setPayDate(new Date())
                    .build();

        // Create a person object
        Person person = new Person.Builder()
                .setContactNo("1234567890")
                .setName("John")
                .setSurname("Doe")
                .setEmail("john.doe@example.com")
                .setPassword("password")
                .build();

        // Create a customer object
        Customer customer = new Customer.Builder()
                .setIdentity(person)
                .setCustomerId("C001")
                .build();

        // Create an order using the list of products, shipping, payment, and customer details
        order = OrderFactory.createOrder(products, shipping, payment, customer, 270.0f, "Gluten free");
    }

    @Test
    void create() {
        Order created = orderRepository.create(order);
        assertNotNull(created, "Failed to create order");
        System.out.println("Created Order: " + created);
    }

    @Test
    void read() {
        String orderId = "001";
        Order read = orderRepository.read(orderId);
        assertEquals(order, read, "Failed to read order");
        System.out.println("Read Order: " + read);
    }

    @Test
    void update() {
        Order updated = orderRepository.update(new Order.Builder().copy(order).orderNote("Dairy free").build());
        assertNotNull(updated, "Failed to update order");
        System.out.println("Updated Order: " + updated);
    }

    @Test
    void getAll() {
        System.out.println("All Orders: " + orderRepository.getAll());
    }

    @Test
    void delete() {

        Order deleted = orderRepository.delete(order);
        assertNotNull(deleted, "Failed to delete order");
        System.out.println("Deleted Order: " + deleted);
    }
}