package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Person;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Factory.PersonFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IAdminRepositoryTest {

    private IAdminRepository<Admin, String> adminRepository = new AdminRepositoryImp();
    @BeforeEach
    void setUp() {
        Person person1 = PersonFactory.buildPerson("Logan","Coghill","logan@gmail.com","Password2435","36246343");
        Person person2 = PersonFactory.buildPerson("333","555","logan213@gmail.com","Password653","2416375443");
        Person person3 = PersonFactory.buildPerson("444","444","logan676@gmail.com","Password2435","02134656343");
        Person person4 = PersonFactory.buildPerson("555","777","logan457@gmail.com","Password643","046542243");
        Admin admin1 = AdminFactory.buildAdmin(person1);
        Admin admin2 = AdminFactory.buildAdmin(person2);
        Admin admin3 = AdminFactory.buildAdmin(person3);
        Admin admin4 = AdminFactory.buildAdmin(person4);
        adminRepository.create(admin1);
        adminRepository.create(admin2);
        adminRepository.create(admin3);
        adminRepository.create(admin4);
    }

    @Test
    @Order(2)
    void getUserByPerson() {
        Admin admin = adminRepository.getUserByPerson(PersonFactory
                .buildPerson("Logan","Coghill",
                        "logan@gmail.com","Password2435",
                        "36246343"));
        assertNotNull(admin);
        System.out.println(admin);
    }

    @Test
    void getLoginDetails() {
        Person person = PersonFactory.buildPerson("logan@gmail.com", "Password2435");
        Admin admin = adminRepository.getLoginDetails(person);
        assertNotNull(admin);
        System.out.println(admin);
    }

    @Test
    @Order(1)
    void create() {
        Admin admin = AdminFactory.buildAdmin(PersonFactory.buildPerson("Email","Password"));
        assertNotNull(adminRepository.create(admin));
        System.out.println(adminRepository.getAll());
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    @Order(3)
    void getAll() {
        assertNotNull(adminRepository.getAll());
        System.out.println(adminRepository.getAll());
    }
}