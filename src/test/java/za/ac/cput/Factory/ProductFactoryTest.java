package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Product;
import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Mohamed Zouheir 221215794
    Date: 27 March 2024
*/

public class ProductFactoryTest {
    private static Product product1;

    @BeforeAll
    void setUp(){
        product1 = ProductFactory.buildProduct("Chocolate Brownie", 9.99f, 1,"Its a chocolate brownie", "Cocoa", true);
    }
    @Test
    void testNotNull(){
        assertNotNull(product1);

    }

}
