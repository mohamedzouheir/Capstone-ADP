package za.ac.cput.Repository;

import java.util.List;

public interface IProductRepository <T, Id>{
    public T create(T object);

    public T read(Id id);

    public T update(T object);

    public T delete(Id id);

    public List<T> getAll();

}
