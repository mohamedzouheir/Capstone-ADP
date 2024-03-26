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

  @OneToMany

    private List<Order> orders;
    protected Customer(){};

    //Constructor for builder

    private Customer(Builder obj) {
        this.identity = obj.identity;
        this.customerId = obj.customerId;
        this.orders = obj.orders;
    }

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

    public static class Builder{

        private Person identity;
        private String customerId;
        private List<Order> orders;

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

        public Builder copy(Customer obj){
            this.customerId= obj.customerId;
            this.identity = obj.identity;
            this.orders = obj.orders;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}

