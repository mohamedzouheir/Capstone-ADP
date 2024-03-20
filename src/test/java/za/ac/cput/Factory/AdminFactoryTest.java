package za.ac.cput.Factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Person;
import za.ac.cput.Utils.AdminUtils;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    Person person;
    String adminId;
    @BeforeEach
    void setUp() {
        person = PersonFactory.buildPerson("Logan", "Coghill", "221534067@mycpt.ac.za", "Str0ngPassW0rd!", "0231546975");
        adminId = AdminUtils.generateId();
    }

    @Test
    void buildAdmin() {
        Admin admin = AdminFactory.buildAdmin(person,adminId);
        assert admin != null;
        assertEquals(admin.getIdentity(),person);
        System.out.println(admin);
    }

    @Test
    void testBuildAdmin() {
        Admin admin = AdminFactory.buildAdmin(person);
        assert admin != null;
        assertEquals(admin.getIdentity(),person);
        System.out.println("Person: " + person);
        System.out.println("Admin: " + admin);
    }

    @AfterEach
    void tearDown() {
        person = null;
        adminId = null;
    }
}