package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Shipping;
import za.ac.cput.Factory.ShippingFactory;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class IShippingRepositoryTest {
    private static IShippingRepository<Shipping, String> repository = new ShippingRepositoryImp();
    private Shipping shipping = ShippingFactory.buildShipping("4524", "67 Claire Street", "109 9th Avenue", "Cape Town", "Western Cape", 7882, "Out on delivery");


    @Test
    @Order(1)
    void create() {
        Object created = repository.create(shipping);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        String shippingID = "4524";
        Object read = repository.read(shippingID);
        assertEquals(read, shipping);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Object updated = repository.update(new Shipping.Builder().copy(shipping).setCity("Free State").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(shipping.getShippingID()));
        System.out.println("Success: deleted shipping");
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(repository.getAll());
    }
}