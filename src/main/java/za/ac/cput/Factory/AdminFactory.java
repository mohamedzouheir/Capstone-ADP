package za.ac.cput.Factory;

import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Person;
import za.ac.cput.Utils.AdminUtils;

public class AdminFactory {

    public static Admin buildAdmin(Person person, String adminId){
        if(AdminUtils.isValid(person) || AdminUtils.isValid(adminId)){
            return new Admin.Builder()
                    .setIdentity(person)
                    .setAdminId(adminId)
                    .build();
        }else{
            return null;
        }
    }

    public static Admin buildAdmin(Person person){
        if(AdminUtils.isValid(person)){
            return new Admin.Builder().setIdentity(person)
                    .setAdminId(AdminUtils.generateId())
                    .build();
        }else{
            return null;
        }
    }
}
