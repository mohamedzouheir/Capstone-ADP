package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Shipping;

import static org.junit.jupiter.api.Assertions.*;

class ShippingFactoryTest {

    @Test
    void buildShipping() {
        String shippingID = "12345";
        String Address1 = "78 6th Avenue";
        String Address2 = "90 Pluto Road ";
        String City = "Cape Town";
        String State = "Western Cape" ;
        int postalCode = 898989;
        String trackStatus = "Shipped";

        Shipping shipping = ShippingFactory.buildShipping(shippingID, Address1, Address2, City, State, postalCode, trackStatus);

        assertNotNull(shipping);
        assertEquals(shippingID, shipping.getShippingID());
        assertEquals(Address1, shipping.getAddress1());
        assertEquals(Address2, shipping.getAddress2());
        assertEquals(City, shipping.getCity());
        assertEquals(State, shipping.getState());
        assertEquals(postalCode, shipping.getPostalCode());
        assertEquals(trackStatus, shipping.getTrackStatus());
    }


    @Test
    void testBuildShipping() {
        String shippingID = "12345";
        String Address1 = "78 6th Avenue";
        String Address2 = "90 Pluto Road ";
        String City = "Cape Town";
        String State = "Western Cape" ;
        int postalCode = 898989;
        String trackStatus = "Shipped";

        Shipping shippingWithNotNullFirstName = ShippingFactory.buildShipping(shippingID, Address1, Address2, City, State, postalCode, trackStatus);
        assertNotNull(shippingWithNotNullFirstName);
    }
}