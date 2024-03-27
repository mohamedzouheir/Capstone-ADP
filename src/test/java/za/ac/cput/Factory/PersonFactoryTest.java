package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonFactoryTest {

    @Test
    void buildPerson() {
        Person person = PersonFactory.buildPerson("Logan","Coghill","Email.com","Password","089359");
        assertNotNull(person);
    }

    @Test
    void testBuildPerson() {
        Person person = PersonFactory.buildPerson("Email.com","Password");
        assertNotNull(person);
    }
}