package za.ac.cput.Factory;
/*
    Payment Factory Test Class
    Author: Sheldon Luke Arendse 221190384
    Date: 21 March 2024
*/
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Payment;
import za.ac.cput.Utils.PaymentUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    Payment payObj;
    Date payDate;
    String paymentId;

    @BeforeEach
    void setUp() {
        payDate = new Date();
        paymentId = PaymentUtils.generateId();

    }

    // Testing if payment object is not null and attributes are correct
    @Test
    void buildPayment() {
        Payment payment = PaymentFactory.buildPayment(paymentId, 120.50, payDate, "Credit Card");
        assertNotNull(payment);
        assertNotNull(payment.getPaymentId());
        assertEquals(120.50, payment.getAmount());
        assertEquals(payDate, payment.getPayDate());
        assertEquals("Credit Card", payment.getPayMethod());
        System.out.println("Payment Test: " + payment);
    }

    // Testing payment object with no PaymentID
    @Test
    void testBuildPaymentNoPaymentId() {
        Payment payment = PaymentFactory.buildPayment(120.50, payDate, "Credit Card");
        assertNotNull(payment);
        assertNotNull(payment.getPaymentId());
        assertEquals(120.50, payment.getAmount());
        assertEquals(payDate, payment.getPayDate());
        assertEquals("Credit Card", payment.getPayMethod());
        System.out.println("Payment Test: " + payment);
    }

    @AfterEach
    void tearDown() {
        payObj = null;
        payDate = null;
    }
}
