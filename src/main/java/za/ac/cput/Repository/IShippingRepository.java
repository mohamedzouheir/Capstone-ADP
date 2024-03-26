package za.ac.cput.Repository;
import za.ac.cput.Domain.Shipping;
import java.util.List;
public interface IShippingRepository<T, Id>{
    public T create(T t);
    public T read(Id id);
    public T update(T obj);
    boolean delete(Id id);

    List<Shipping> getAll();

}
