package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Product;
import za.ac.cput.Factory.ProductFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Mohamed Zouheir 221215794
    Date: 27 March 2024
*/

public class IProductRepositoryTest {

    private static  IProductRepository<Product, String> repo = new ProductRepositoryImp();
    private static Product product1 = ProductFactory.buildProduct("Chocolate Brownie", 9.99f, 1,"Its a chocolate brownie", "Cocoa", true);

    @Test
    void createTest(){
        repo.create(product1);
        assertNotNull(repo);
    }

    @Test
    void readTest(){
        assertNotNull(repo.read(product1.getProductId()));

    }

    @Test
    void updateTest(){
        product1 = new Product.Builder()
                .copy(product1)
                .setPrice(5f)
                .setName("Chocolate Bar")
                .setDescription("A chocolate bar")
                .build();

        repo.update(product1);
        assertEquals(product1,repo.read(product1.getProductId()));

    }

    @Test
    void deleteTest(){
        repo.delete(product1.getProductId());
        assertNull(repo.read(product1.getProductId()));
    }



}
