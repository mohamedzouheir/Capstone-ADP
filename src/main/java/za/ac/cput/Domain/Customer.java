package za.ac.cput.Domain;

/*
Customer.Java
Customer Model Class
Author: Aa'ishah Van Witt
Date: 26 March 2024
 */

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

//Create POJO - Customer Database Entity
@Entity
public class Customer {

    //Define relationship between Customer and Person
    @OneToOne
    private Person identity;

    //PK for Customer Entity
    @Id
    private String customerId;

    //Define relationship between Customer and Order
    @OneToMany
    private List<Order> orders;

    protected Customer() {
    }

    //Constructor for Builder
    private Customer(Builder obj) {
        this.identity = obj.identity;
        this.customerId = obj.customerId;
        this.orders = obj.orders;
    }

    //Getters
    public Person getIdentity() {
        return identity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(identity, customer.identity) && Objects.equals(customerId, customer.customerId) && Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, customerId, orders);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "identity=" + identity +
                ", customerId='" + customerId + '\'' +
                ", orders=" + orders +
                '}';
    }

    //Creating Builder class with identical attributes
    public static class Builder {

        private Person identity;
        private String customerId;
        private List<Order> orders;

        //Setters
        public Builder setIdentity(Person identity) {
            this.identity = identity;
            return this;
        }

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setOrders(List<Order> orders) {
            this.orders = orders;
            return this;
        }

        //Method to create builder with Customer object
        public Builder copy(Customer obj) {
            this.customerId = obj.customerId;
            this.identity = obj.identity;
            this.orders = obj.orders;
            return this;
        }

        //Builds and returns new Customer object
        public Customer build() {
            return new Customer(this);
        }
    }
}

