package za.ac.cput.Repository;

import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepositoryImp implements IPersonRepository<Person, String>{
    private final List<Person> FakeDAO = new ArrayList<>();
    @Override
    public Person create(Person obj) {
        FakeDAO.add(obj);
        return obj;
    }

    @Override
    public Person read(String email) {
        for(Person obj: FakeDAO){
            if(obj.getEmail().equals(email)){
                return obj;
            }
        }
        return null;
    }

    @Override
    public Person update(Person obj) {
        for(Person obj1:FakeDAO){
            if(obj1.getEmail().equals(obj.getEmail())){
                FakeDAO.remove(obj1);
                FakeDAO.add(obj);
                return obj;
            }
        }
        return null;
    }

    @Override
    public Person delete(Person obj) {
        for(Person person:FakeDAO){
            if(person.equals(obj)){
                FakeDAO.remove(obj);
            }
        }
        return null;
    }
}
