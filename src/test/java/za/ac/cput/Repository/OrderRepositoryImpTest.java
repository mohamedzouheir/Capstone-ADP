package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Repository.OrderRepositoryImp;
import za.ac.cput.Domain.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderRepositoryTest {
    private OrderRepositoryImp orderRepository;

    // Set up the repository before each test
    @BeforeEach
    public void setUp() {
        orderRepository = new OrderRepositoryImp();
    }

    // Test for the create method
    @Test
    public void testCreate() {
        Order order = new Order();
        Order createdOrder = orderRepository.create(order);

        // Assert that the created order is not null and is equal to the original order
        assertNotNull(createdOrder);
        assertEquals(order, createdOrder);
    }

    // Test for the read method
    @Test
    public void testRead() {
        Order order = new Order();
        order.setOrderId("234");
        orderRepository.create(order);

        // Read the order with ID "234"
        Order readOrder = orderRepository.read("234");

        // Assert that the read order is not null and is equal to the original order
        assertNotNull(readOrder);
        assertEquals(order, readOrder);
    }

    // Test for the update method
    @Test
    public void testUpdate() {
        Order order = new Order();
        order.setOrderId("234");
        orderRepository.create(order);

        Order updatedOrder = new Order();
        updatedOrder.setOrderId("234");
        Order returnedOrder = orderRepository.update(updatedOrder);

        // Assert that the returned order after update is not null and is equal to the updated order
        assertNotNull(returnedOrder);
        assertEquals(updatedOrder, returnedOrder);
    }

    // Test for the delete method
    @Test
    public void testDelete() {
        Order order = new Order();
        order.setOrderId("234");
        orderRepository.create(order);

        // Delete the order and assert that it's not null and is equal to the original order
        Order deletedOrder = orderRepository.delete(order);
        assertNotNull(deletedOrder);
        assertEquals(order, deletedOrder);
    }

    // Test for the getAll method
    @Test
    public void testGetAll() {
        Order order1 = new Order();
        Order order2 = new Order();
        orderRepository.create(order1);
        orderRepository.create(order2);

        // Get all orders and assert that there are two orders and they contain the created orders
        List<Order> allOrders = orderRepository.getAll();
        assertEquals(2, allOrders.size());
        assertTrue(allOrders.contains(order1));
        assertTrue(allOrders.contains(order2));
    }
}