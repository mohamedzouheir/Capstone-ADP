package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Person;
import za.ac.cput.Factory.PersonFactory;

import static org.junit.jupiter.api.Assertions.*;

class IPersonRepositoryTest {

    private PersonRepositoryImp personRepository;
    @BeforeEach
    void setUp() {
        if(personRepository == null){
            personRepository = new PersonRepositoryImp();
        }
    }

    @Test
    void create() {
        for(int i=0;i<5;i++){
            Person person;
            person = PersonFactory.buildPerson("Name"+i,"Surname"+i,"Email.com"+i,"Password"+i,"235156"+i);
            assertNotNull(personRepository.create(person));
        }
    }

    @Test
    void read() {
        Person person =personRepository.read("Email.com2");
        assertNotNull(person);
        System.out.println(person);
    }

    @Test
    void update() {
        Person person = PersonFactory.buildPerson("Email.com3","NewPassword");
        System.out.println(personRepository.update(person));
        assertNotNull(person);
    }

    @Test
    void delete() {
        Person person = PersonFactory.buildPerson("Email.com3","NewPassword");
        assertNotNull(personRepository.delete(person));
    }
}