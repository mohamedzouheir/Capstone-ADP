package za.ac.cput.Domain;
/*
    Admin.java
    Admin Model class
    Author: Logan Kalib Coghill 221534067
    Date: 19 March 2024
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Person {
    @Id
    private long contactNo;
    private String name;
    private String surname;
    private String email;
    private String password;

    protected Person(){}

    private Person(Builder obj){
        this.contactNo = obj.contactNo;
        this.name = obj.name;
        this.surname = obj.surname;
        this.email = obj.email;
        this.password = obj.password;
    }

    public long getContactNo() {
        return contactNo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return contactNo == person.contactNo && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(email, person.email) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactNo, name, surname, email, password);
    }

    @Override
    public String toString() {
        return "Person{" +
                "contactNo=" + contactNo +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private long contactNo;
        private String name, surname, email, password;

        public Builder setContactNo(long contactNo) {
            this.contactNo = contactNo;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Person obj){
            this.contactNo = obj.contactNo;
            this.name = obj.name;
            this.surname = obj.surname;
            this.email = obj.email;
            this.password = obj.password;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
