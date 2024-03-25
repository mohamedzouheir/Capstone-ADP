package za.ac.cput.Repository;
/*
    Payment Factory Class
    Author: Sheldon Luke Arendse 221190384
    Date: 21 March 2024
*/
import za.ac.cput.Domain.Payment;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepositoryImp implements IPaymentRepository <Payment, String> {
    private final List<Payment> paymentList = new ArrayList<>();

    // Add a Payment object to the paymentList
    @Override
    public Payment create(Payment obj) {
        paymentList.add(obj);
        return obj;
    }

    // Check if the paymentId of the current Payment object matches the String
    @Override
    public Payment read(String s) {
        for(Payment payment : paymentList) {
            if (payment.getPaymentId().equals(s)) {
                return payment;
            }
        }
        return null;
    }

    /* Compares the 2 values of paymentId - if they are equal then payment obj
     will be removed and replaced with the same values */
    @Override
    public Payment update(Payment obj) {
        for (Payment payment : paymentList) {
            if (payment.getPaymentId().equals(obj.getPaymentId())) {
                paymentList.remove(payment);
                paymentList.add(obj);
                return obj;
            }
        }
        return null;
    }

    // Checks if the object is not null, if so then it will remove the object from the paymentList
    @Override
    public Payment delete(Payment obj) {
        if (obj != null) {
            if (paymentList.remove(obj)) {
                return obj;
            }
        }
        return null;
    }

    // Returns the array list named paymentList
    @Override
    public List<Payment> getAll() {
        return new ArrayList<>((paymentList));
    }

}
