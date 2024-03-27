package za.ac.cput.Domain;
/*
    Shipping.java
    Shipping Model class
    Author: Uzair Rabin 221013245
    Date: 26 March 2024
*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Shipping {

    @Id
    private String shippingID;
    private String Address1;
    private String Address2;
    private String City;
    private String State;
    private int postalCode;
    private String trackStatus;

    protected Shipping() {

    }

    private Shipping(Builder builder) {
        this.shippingID = builder.shippingID;
        this.Address1 = builder.Address1;
        this.Address2 = builder.Address2;
        this.City = builder.City;
        this.State = builder.State;
        this.postalCode = builder.postalCode;
        this.trackStatus = builder.trackStatus;

    }

    public String getShippingID() {
        return shippingID;
    }

    public String getAddress1() {
        return Address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getTrackStatus() {
        return trackStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipping shipping = (Shipping) o;
        return Objects.equals(shippingID, shipping.shippingID) && Objects.equals(Address1, shipping.Address1) && Objects.equals(Address2, shipping.Address2) && Objects.equals(City, shipping.City) && Objects.equals(State, shipping.State) && Objects.equals(postalCode, shipping.postalCode) && Objects.equals(trackStatus, shipping.trackStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shippingID, Address1, Address2, City, State, postalCode, trackStatus);
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "shippingID='" + shippingID + '\'' +
                ", Address1='" + Address1 + '\'' +
                ", Address2='" + Address2 + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", postalCode=" + postalCode +
                ", trackStatus='" + trackStatus + '\'' +
                '}';
    }

    public static class Builder {
        private String shippingID;
        private String Address1;
        private String Address2;
        private String City;
        private String State;
        private int postalCode;
        private String trackStatus;

        public Builder setShippingID(String shippingID) {
            this.shippingID = shippingID;
            return this;
        }

        public Builder setAddress1(String Address1) {
            this.Address1 = Address1;
            return this;

        }

        public Builder setAddress2(String Address2) {
            this.Address2 = Address2;
            return this;
        }

        public Builder setCity(String City) {
            this.City = City;
            return this;

        }

        public Builder setState(String State) {
            this.State = State;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setTrackStatus(String trackStatus) {
            this.trackStatus = trackStatus;
            return this;
        }
        public Builder copy (Shipping shipping) {
            this.shippingID = shipping.shippingID;
            this.Address1 = shipping.Address1;
            this.Address2 = shipping.Address2;
            this.City = shipping.City;
            this.State = shipping.State;
            this.postalCode = shipping.postalCode;
            this.trackStatus = shipping.trackStatus;
            return this;
        }

        public Shipping build() {
            return new Shipping(this);
        }
    }
}