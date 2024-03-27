package za.ac.cput.Domain;
import java.util.List;

public class Order {

    private String orderID;
    private List<Product> products;
    private Shipping shippingID;
    private Payment paymentID;
    private Customer customerID;
    private float total;
    private String orderNote;

    //Constructor that takes Builder Object
    private Order (Builder builder){
        this.orderID = builder.orderID;
        this.products =builder.products;
        this.shippingID=builder.shippingID;
        this.paymentID= builder.paymentID;
        this.customerID = builder.customerID;
        this.total = builder.total;
        this.orderNote = builder.orderNote;
    }


    //Builder class for the Order entity
    public static class Builder{
        private String orderID;
        private List<Product> products;
        private Shipping shippingID;
        private Payment paymentID;
        private Customer customerID;
        private float total;
        private String orderNote;

        // set orderID and return the Builder object
        public Builder orderID (String orderID){
          this.orderID = orderID;
          return this;

        }

        // set products  and return the Builder object
        public Builder products (List<Product> products){
           this.products = products;
           return this;
        }

        // set shippingID and return Builder object

        public Builder shippingID(Shipping shippingID){
            this.shippingID = shippingID;
            return this;

        }
        // set the paymentID and return the Builder object
        public Builder paymentID(Payment paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        // Set customerID and return the Builder object
        public Builder customerID(Customer customerID) {
            this.customerID = customerID;
            return this;
        }

        // Set the total and return the Builder object
        public Builder total(float total) {
            this.total = total;
            return this;
        }

        // Set the orderNote and return the Builder object
        public Builder orderNote(String orderNote) {
            this.orderNote = orderNote;
            return this;
        }

        // construct and return the final Order object
        public Order build() {
            return new Order(this);
        }
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Shipping getShippingID() {
        return shippingID;
    }

    public void setShippingID(Shipping shippingID) {
        this.shippingID = shippingID;
    }

    public Payment getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Payment paymentID) {
        this.paymentID = paymentID;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", products=" + products +
                ", shippingID=" + shippingID +
                ", paymentID=" + paymentID +
                ", customerID=" + customerID +
                ", total=" + total +
                ", orderNote='" + orderNote + '\'' +
                '}';
    }
}

