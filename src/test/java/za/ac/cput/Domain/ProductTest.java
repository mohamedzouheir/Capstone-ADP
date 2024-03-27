package za.ac.cput.Domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private static Product product1;
    private static Product product2;

    @BeforeAll
    static void setUp(){
        product1 = ProductFactory.buildProduct("Chocolate Brownie", 9.99f, 1,"Its a chocolate brownie", "Cocoa", true);
        product2 = product1;

    }

    @Test
    void testEqual(){
        assertEquals(product1, product2 );
    }



}