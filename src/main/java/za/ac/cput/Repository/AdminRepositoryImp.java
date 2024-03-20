package za.ac.cput.Repository;

import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Person;

import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImp implements IAdminRepository<Admin,String>{

    private final List<Admin> FakeDAO = new ArrayList<>();
    @Override
    public Admin getUserByPerson(Person person) {
            for (Admin admin : FakeDAO) {
                if(admin.getIdentity().equals(person)){
                    return admin;
                }
            }
            return null;
    }

    @Override
    public Admin getLoginDetails(Person person) {
        for (Admin admin : FakeDAO) {
            if(admin.getIdentity().getEmail().equals(person.getEmail())
                    && admin.getIdentity().getPassword().equals(person.getPassword())){
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin create(Admin obj) {
        FakeDAO.add(obj);
        return obj;
    }

    @Override
    public Admin read(String s) {
        return null;
    }

    @Override
    public Admin update(Admin obj) {
        return null;
    }

    @Override
    public Admin delete(Admin obj) {
        return null;
    }

    @Override
    public List<Admin> getAll() {
        return new ArrayList<>(FakeDAO);
    }
}
