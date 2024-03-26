package za.ac.cput.Repository;
/*
    Payment Factory Class
    Author: Sheldon Luke Arendse 221190384
    Date: 21 March 2024
*/
import java.util.List;

public interface IPaymentRepository <T, ID>{
    T create(T obj); // Creates a new Object obj in the repository
    T read(ID obj);  // obj is the ID of the object to be read
    T update(T obj);  // Update the obj in the repository
    T delete(T obj);  // obj is the object to be deleted
    List<T> getAll();  // returns a list containing all objects in the repository
}
