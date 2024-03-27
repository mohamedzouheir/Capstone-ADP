package za.ac.cput.Domain;

/*
    Payment Model Class
    Author: Sheldon Luke Arendse 221190384
    Date: 21 March 2024
*/
import java.util.Date;
import java.util.Objects;

public class Payment extends Order{
    private final String paymentId;
    private final String payMethod;
    private final double amount;
    private final Date payDate;

    public Payment() {
    }

    private Payment(Builder obj) {
        this.paymentId = obj.paymentId;
        this.payMethod = obj.payMethod;
        this.amount = obj.amount;
        this.payDate = obj.payDate;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPayDate() {
        return payDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment payment)) return false;
        return Double.compare(getAmount(), payment.getAmount()) == 0 && Objects.equals(getPaymentId(), payment.getPaymentId()) && Objects.equals(getPayMethod(), payment.getPayMethod()) && Objects.equals(getPayDate(), payment.getPayDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentId(), getPayMethod(), getAmount(), getPayDate());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "PaymentID = '" + paymentId + '\'' +
                ", Pay Method = '" + payMethod + '\'' +
                ", amount = " + amount +
                ", payDate=  " + payDate +
                '}' + "\n";
    }

    public static class Builder {
        private String paymentId;
        private String payMethod;
        private double amount;
        private Date payDate;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setPayMethod(String payMethod) {
            this.payMethod = payMethod;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPayDate(Date payDate) {
            this.payDate = payDate;
            return this;
        }

        public Builder copy(Payment obj) {
            this.paymentId = obj.paymentId;
            this.payMethod = obj.payMethod;
            this.amount = obj.amount;
            this.payDate = obj.payDate;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }

    }
}
