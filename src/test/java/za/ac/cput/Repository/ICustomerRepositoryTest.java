package za.ac.cput.Repository;

/*
Customer.Java
Customer Model Class
Author: Aa'ishah Van Witt
Date: 26 March 2024
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.*;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Factory.PersonFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ICustomerRepositoryTest {

    private ICustomerRepository<Customer, String> customerRepository;

    @BeforeEach
    void setUp() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImp();
            for (int x = 0; x < 5; x++) {
                Person person1 = PersonFactory.buildPerson("Aaishah" + x, "Van Witt" + x, "221539395@mycput.ac.za" + x, "P@ssWord" + x, "0212345678" + x);
                Customer customer1 = CustomerFactory.buildCustomer(person1);
                customerRepository.create(customer1);
            }
        }
    }

    @Test
    @Order(2)
    void getUserByPerson() {
        List<Customer> person = customerRepository.getAll();
        Customer customer = customerRepository.getUserByPerson(person.get(2).getIdentity());
        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    @Order(3)
    void getLoginDetails() {
        Person person = PersonFactory.buildPerson("221539395@mycput.ac.za3", "P@ssWord3");
        Customer customer = customerRepository.getLoginDetails(person);
        assertNotNull(customer);
        System.out.println(customer);
    }

    @Test
    @Order(1)
    void create() {
        Customer customer = CustomerFactory.buildCustomer(PersonFactory.buildPerson("Email", "Password"));
        assertNotNull(customerRepository.create(customer));
        System.out.println(customerRepository.getAll());
    }

    @Test
    @Order(5)
    void read() {
        String c = customerRepository.getAll().getFirst().getCustomerId();
        assertNotNull(customerRepository.read(c));
        System.out.println(customerRepository.read(c));
    }

    @Test
    @Order(6)
    void update() {
        Person person = PersonFactory.buildPerson("test", "test", "test@email.com", "PasswordT", "0213456789");
        Customer updater = new Customer.Builder()
                .copy(customerRepository.getAll().getFirst())
                .setIdentity(person)
                .build();

        assertNotNull(customerRepository.update(updater));
        System.out.println(customerRepository.getAll());
        System.out.println(updater);
    }

    @Test
    @Order(8)
    void delete() {
        Customer customer = customerRepository.getAll().getLast();
        System.out.println(customerRepository.getAll());
        assertNotNull(customerRepository.delete(customer));
        System.out.println(customerRepository.getAll());
    }

    @Test
    @Order(4)
    void getAll() {
        assertNotNull(customerRepository.getAll());
        System.out.println(customerRepository.getAll());
    }
}

