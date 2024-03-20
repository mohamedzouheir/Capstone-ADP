package za.ac.cput.Repository;

/*
    Admin.java
    Admin Model class
    Author: Logan Kalib Coghill 221534067
    Date: 19 March 2024
*/
import za.ac.cput.Domain.Person;

import java.util.List;

public interface IAdminRepository <T,Id>{
    public T getUserByPerson(Person person);
    public T getLoginDetails(Person person);
    public T create(T obj);
   public T read(Id id);
    public T update(T obj);
    public T delete(T obj);
    public List<T> getAll();

}
