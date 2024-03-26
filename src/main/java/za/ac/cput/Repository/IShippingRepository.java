package za.ac.cput.Repository;
/*
    IShippingRepository.java
    IShippingRepository  class
    Author: Uzair Rabin 221013245
    Date: 26 March 2024
*/
import za.ac.cput.Domain.Shipping;
import java.util.List;
public interface IShippingRepository<T, Id>{
    public T create(T t);
    public T read(Id id);
    public T update(T obj);
    boolean delete(Id id);

    List<Shipping> getAll();

}
