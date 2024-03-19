package za.ac.cput.Domain;
/*
    Admin.java
    Admin Model class
    Author: Logan Kalib Coghill 221534067
    Date: 19 March 2024
*/


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Objects;

//Define the Pojo as a database Entity
@Entity
public class Admin {
    //Make the relationship between Admin and Person
    @OneToOne
    private Person identity;
    //Unique identifier for Entity
    @Id
    private String adminId;

    protected Admin(){};

    //Constructor for builder
    private Admin(Builder obj){
        this.identity = obj.identity;
        this.adminId = obj.adminId;
    }


    public Person getIdentity() {
        return identity;
    }

    public String getAdminId() {
        return adminId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(identity, admin.identity) && Objects.equals(adminId, admin.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, adminId);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "identity=" + identity +
                ", adminId='" + adminId + '\'' +
                '}';
    }

    // Define Builder class with same attributes
    public static class Builder{
        private Person identity;
        private String adminId;

        //Define setters
        public Builder setIdentity(Person identity) {
            this.identity = identity;
            return this;
        }

        public Builder setAdminId(String adminId) {
            this.adminId = adminId;
            return this;
        }

        // Method to create a builder out of an Admin obj
        public Builder copy(Admin obj){
            this.adminId = obj.adminId;
            this.identity = obj.identity;
            return this;
        }

        // build and return new Admin obj
        public Admin build(){
            return new Admin(this);
        }
    }
}
