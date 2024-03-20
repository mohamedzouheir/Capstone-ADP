package za.ac.cput.Repository;

import za.ac.cput.Domain.Admin;
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
