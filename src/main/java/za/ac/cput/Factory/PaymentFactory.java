package za.ac.cput.Factory;

/*
    Payment Factory Class
    Author: Sheldon Luke Arendse 221190384
    Date: 21 March 2024
*/
import jakarta.validation.Valid;
import za.ac.cput.Domain.Payment;
import za.ac.cput.Utils.PaymentUtils;

import java.util.Date;

public class PaymentFactory {

    // Build payment object with an existing payment ID
    public static Payment buildPayment(@Valid String paymentId, double amount, Date payDate, String payMethod) {
        if (PaymentUtils.isNotBlankOrEmpty(payMethod) || PaymentUtils.isNotBlankOrEmpty(paymentId)) {
            return new Payment.Builder()
                    .setPaymentId(paymentId)
                    .setAmount(amount)
                    .setPayDate(payDate)
                    .setPayMethod(payMethod)
                    .build();
        } else {
            return null;
        }
    }

    // Generate a new payment ID
    public static Payment buildPayment(double amount, Date payDate, String payMethod) {
        if (PaymentUtils.isNotBlankOrEmpty(payMethod)) {
            return new Payment.Builder()
                    .setPaymentId(PaymentUtils.generateId())
                    .setAmount(amount)
                    .setPayDate(payDate)
                    .setPayMethod(payMethod)
                    .build();
        }
            return null;
    }
}
