package za.ac.cput.Repository;
/*
    Payment Repository Test Class
    Author: Sheldon Luke Arendse 221190384
    Date: 21 March 2024
*/
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Payment;
import za.ac.cput.Factory.PaymentFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class IPaymentRepositoryTest {
    Date payDate = new Date();
    private IPaymentRepository <Payment, String> paymentRepository;

    // Setting up dummy data that is differentiated by the amount
    @BeforeEach
    void setUp() {
        if (paymentRepository == null) {
            paymentRepository = new PaymentRepositoryImp();

            for (int i = 0; i < 5; i++) {
                Payment payment1 = PaymentFactory.buildPayment(20.11 * i, payDate, "Cash");
                paymentRepository.create(payment1);
            }
        }
    }

    @Test
    void create() {
        Payment payment = PaymentFactory.buildPayment(25, payDate, "Debit Card");
        assertNotNull(paymentRepository.create(payment));
        System.out.println(paymentRepository.getAll());
    }

    @Test
    void read() {
        String s = paymentRepository.getAll().getFirst().getPaymentId();
        assertNotNull(paymentRepository.read(s));
        System.out.println("Read\n--------------\n");
        System.out.println(paymentRepository.read(s));
    }

    @Test
    void update() {
        Payment payment = PaymentFactory.buildPayment(1, payDate, "Different Pay Method");
        assert payment != null;
        Payment updatedPayment = new Payment.Builder()
                .copy(paymentRepository.getAll().getFirst())
                .setAmount(payment.getAmount())
                .build();

        assertNotNull(paymentRepository.update(updatedPayment));
        System.out.println(paymentRepository.getAll());
        System.out.println("UPDATED PAYMENT: " + updatedPayment);
    }

    @Test
    void delete() {
        Payment payment = paymentRepository.getAll().getFirst();
        System.out.println("Original Payment List" +
                "\n-----------------------\n" +
                paymentRepository.getAll());
        assertNotNull(paymentRepository.delete(payment));
        System.out.println("New Payment List" +
                "\n-----------------------\n" +
                paymentRepository.getAll());

    }

    @Test
    void getAll() {
        assertNotNull(paymentRepository.getAll());
        System.out.println("getAll() Payments" +
                "\n----------------------\n" +
                paymentRepository.getAll());
    }
}