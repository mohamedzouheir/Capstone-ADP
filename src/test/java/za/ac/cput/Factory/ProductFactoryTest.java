package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Product;
import static org.junit.jupiter.api.Assertions.*;

public class ProductFactoryTest {
    private static Product product1;

    @Test
    void setUp(){
        product1 = ProductFactory.buildProduct("Chocolate Brownie", 9.99f, 1,"Its a chocolate brownie", "Cocoa", true);
    }
    @Test
    void testNotNull(){
        assertNotNull(product1);

    }

}
