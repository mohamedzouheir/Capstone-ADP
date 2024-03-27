package za.ac.cput.Repository;

/*
ICustomerRepository.Java
Customer Repository Interface
Author: Aa'ishah Van Witt
Date: 26 March 2024
 */

import za.ac.cput.Domain.Person;

import java.util.List;

public interface ICustomerRepository <T, Id>{

    public T getUserByPerson(Person person);
    public T getLoginDetails(Person person);
    public T create(T obj);
    public T read(Id obj);
    public T update(T obj);
    public T delete(T obj);
    public List<T> getAll();


}
