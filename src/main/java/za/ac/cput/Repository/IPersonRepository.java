package za.ac.cput.Repository;
/*
    IPersonRepository.java
    Person repository interface class
    Author: Logan Kalib Coghill 221534067
    Date: 19 March 2024
*/
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Person;

public interface IPersonRepository <T,ID>{
    T create(T obj);
    T read(ID email);

    T update(T obj);
    T delete(T obj);
}
