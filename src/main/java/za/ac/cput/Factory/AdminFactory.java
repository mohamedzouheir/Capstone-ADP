package za.ac.cput.Factory;
/*
    AdminFactory.java
    Admin Factory class
    Author: Logan Kalib Coghill 221534067
    Date: 19 March 2024
*/
import jakarta.validation.Valid;
import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Person;
import za.ac.cput.Utils.AdminUtils;

public class AdminFactory {

    public static Admin buildAdmin(@Valid Person person, @Valid String adminId){
        if(AdminUtils.isValid(person) || AdminUtils.isValid(adminId)){
            return new Admin.Builder()
                    .setIdentity(person)
                    .setAdminId(adminId)
                    .build();
        }else{
            return null;
        }
    }

    public static Admin buildAdmin(@Valid Person person){
        if(AdminUtils.isValid(person)){
            return new Admin.Builder().setIdentity(person)
                    .setAdminId(AdminUtils.generateId())
                    .build();
        }else{
            return null;
        }
    }
}
