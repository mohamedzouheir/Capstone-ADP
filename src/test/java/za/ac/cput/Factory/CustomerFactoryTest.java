package za.ac.cput.Factory;

/*
Customer.Java
Customer Model Class
Author: Aa'ishah Van Witt
Date: 26 March 2024
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Customer;
import za.ac.cput.Domain.Person;
import za.ac.cput.Utils.CustomerUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerFactoryTest {

    Person person;
    String customerId;


    @BeforeEach
    void setUp() {
        person = PersonFactory.buildPerson("Aaishah","Van Witt","221539395@mycput.ac.za","P@ssWord","0123456789");
        customerId = CustomerUtils.generateId();

    }

    @Test
    void buildCustomer(){
        Customer customer = CustomerFactory.buildCustomer(person);
        assert customer != null;
        assertEquals(customer.getIdentity(),person);
        System.out.println(customer);
    }

    @Test
    void testBuildCustomer(){
        Customer customer = CustomerFactory.buildCustomer(person);
        assert customer != null;
        assertEquals(customer.getIdentity(),person);
        System.out.println("Person: " +person);
        System.out.println("Customer: "+customer);
    }

    @AfterEach
    void tearDown(){
        person = null;
        customerId = null;
    }
}
