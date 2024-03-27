package za.ac.cput.Factory;
/*
    ShippingFactory.java
    ShippingFactory class
    Author: Uzair Rabin 221013245
    Date: 26 March 2024
*/
import za.ac.cput.Domain.Shipping;
import za.ac.cput.Utils.ShippingUtils;
public class ShippingFactory {
    public static Shipping buildShipping(String shippingID, String Address1, String Address2, String City, String State, int postalCode, String trackStatus) {
        if (ShippingUtils.isNullOrEmpty(shippingID) || ShippingUtils.isNullOrEmpty(Address1) || ShippingUtils.isNullOrEmpty(Address2) || ShippingUtils.isNullOrEmpty(City) || ShippingUtils.isNullOrEmpty(State) || ShippingUtils.isNullOrEmpty(String.valueOf(postalCode)) || ShippingUtils.isNullOrEmpty(trackStatus))
            return null;


        return new Shipping.Builder().setShippingID(shippingID)
                .setAddress1(Address1)
                .setAddress2(Address2)
                .setCity(City)
                .setState(State)
                .setPostalCode(postalCode)
                .setTrackStatus(trackStatus)
                .build();
    }
    public static Shipping buildShipping(String Address1, String Address2, String City, String State, int postalCode, String trackStatus) {
        if (ShippingUtils.isNullOrEmpty(Address1) || ShippingUtils.isNullOrEmpty(Address2) || ShippingUtils.isNullOrEmpty(City) || ShippingUtils.isNullOrEmpty(State) || ShippingUtils.isNullOrEmpty(String.valueOf(postalCode)) || ShippingUtils.isNullOrEmpty(trackStatus))
            return null;

        String shippingID = ShippingUtils.generateID();

        return new Shipping.Builder().setShippingID(shippingID)
                .setAddress1(Address1)
                .setAddress2(Address2)
                .setCity(City)
                .setState(State)
                .setPostalCode(postalCode)
                .setTrackStatus(trackStatus)
                .build();
    }
}
