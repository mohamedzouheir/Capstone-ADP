package za.ac.cput.Repository;
/*
    Admin.java
    Admin Model class
    Author: Logan Kalib Coghill 221534067
    Date: 19 March 2024
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Person;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Factory.PersonFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IAdminRepositoryTest {

    private IAdminRepository<Admin, String> adminRepository;
    @BeforeEach
    void setUp() {
        if(adminRepository == null){
            adminRepository = new AdminRepositoryImp();
            for(int i=0; i<5;i++){
                Person person1 = PersonFactory.buildPerson("Logan"+ i,"Coghill"+ i,"logan@gmail.com"+ i,"Password"+ i,"12345-"+ i);
                Admin admin1 = AdminFactory.buildAdmin(person1);
                adminRepository.create(admin1);
            }
        }
    }

    @Test
    @Order(2)
    void getUserByPerson() {
        List<Admin> person = adminRepository.getAll();
        Admin admin = adminRepository.getUserByPerson(person.get(2).getIdentity());
        assertNotNull(admin);
        System.out.println(admin);
    }

    @Test
    @Order(3)
    void getLoginDetails() {
        Person person = PersonFactory.buildPerson("logan@gmail.com2", "Password2");
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
    @Order(5)
    void read() {
        String s = adminRepository.getAll().getFirst().getAdminId();
        assertNotNull(adminRepository.read(s));
        System.out.println(adminRepository.read(s));
    }

    @Test
    @Order(6)
    void update() {
        Person person = PersonFactory.buildPerson("test","test","test@email.com","Password2","074824024");
        Admin updater = new Admin.Builder()
                .copy(adminRepository.getAll().getFirst())
                .setIdentity(person)
                .build();

        assertNotNull(adminRepository.update(updater));
        System.out.println(adminRepository.getAll());
        System.out.println(updater);
    }

    @Test
    @Order(8)
    void delete() {
        Admin admin = adminRepository.getAll().getLast();
        System.out.println(adminRepository.getAll());
        assertNotNull(adminRepository.delete(admin));
        System.out.println(adminRepository.getAll());
    }

    @Test
    @Order(4)
    void getAll() {
        assertNotNull(adminRepository.getAll());
        System.out.println(adminRepository.getAll());
    }
}