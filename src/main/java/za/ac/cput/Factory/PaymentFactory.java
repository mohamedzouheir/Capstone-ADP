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

    public static Payment buildPayment(@Valid Payment paymentObj, @Valid String paymentId, double amount, Date payDate, String payMethod) {
        if (PaymentUtils.isValid(paymentObj) || PaymentUtils.isNotBlankOrEmpty(paymentId)) {
            return new Payment.Builder()
                    .setPaymentId(paymentId)
                    .setAmount(amount)
                    .setPayDate(payDate)
                    .setPayMethod(payMethod)
                    .build();
        }
        return null;
    }

    public static Payment buildPayment(String paymentId, double amount, Date payDate, String payMethod) {
        if (PaymentUtils.isNullOrEmpty(paymentId)) {
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
