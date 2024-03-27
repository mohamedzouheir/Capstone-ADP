package za.ac.cput.Repository;

/*
CustomerRepositoryImp.Java
Customer Repository Implementation Class
Author: Aa'ishah Van Witt
Date: 26 March 2024
 */

import za.ac.cput.Domain.Customer;
import za.ac.cput.Domain.Person;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImp implements ICustomerRepository<Customer, String> {

    private final List<Customer> CustList = new ArrayList<>();

    @Override
    public Customer getUserByPerson(Person person){
        for (Customer customer : CustList){
            Person personList = customer.getIdentity();
            if(personList.equals(person)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer getLoginDetails(Person person) {
        for (Customer customer : CustList){
            if(customer.getIdentity().getEmail().equals(person.getEmail())
                    && customer.getIdentity().getPassword().equals(person.getPassword())){
                return customer;
            }
        }
        return null;
    }


    @Override
    public Customer create(Customer obj){
        CustList.add(obj);
        return obj;
    }

    @Override
    public Customer read(String c){
        for(Customer customer: CustList){
            if(customer.getCustomerId().equals(c)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer update(Customer obj){
        for(Customer customer:CustList){
            if(customer.getCustomerId().equals(obj.getCustomerId())){
                CustList.remove(customer);
                CustList.add(obj);
                return obj;
            }
        }
        return null;
    }

    @Override
    public Customer delete(Customer obj){
        if(obj != null){
            if(CustList.remove(obj))
                return obj;
        }
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(CustList);
    }
}
