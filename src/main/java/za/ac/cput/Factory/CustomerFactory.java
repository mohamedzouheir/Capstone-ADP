package za.ac.cput.Factory;

/*
CustomerFactory.Java
Customer Factory Class
Author: Aa'ishah Van Witt
Date: 26 March 2024
 */

import jakarta.validation.Valid;
import za.ac.cput.Domain.Customer;
import za.ac.cput.Domain.Order;
import za.ac.cput.Domain.Person;
import za.ac.cput.Utils.CustomerUtils;

import java.util.List;

public class CustomerFactory {

    //Build object of Customer domain
    public static Customer buildCustomer(@Valid Person person, @Valid String customerId) {
        if (CustomerUtils.isValid(person) || CustomerUtils.isValid(customerId)) {
            return new Customer.Builder()
                    .setIdentity(person)
                    .setCustomerId(customerId)
                    .build();
        } else {
            return null;
        }
    }

    public static Customer buildCustomer(@Valid Person person) {
        if (CustomerUtils.isValid(person)) {
            return new Customer.Builder().setIdentity(person)
                    .setCustomerId(CustomerUtils.generateId())
                    .build();
        } else {
            return null;
        }
    }
}
