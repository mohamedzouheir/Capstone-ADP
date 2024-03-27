package za.ac.cput.Domain;

/*
    Author: Mohamed Zouheir 221215794
    Date: 27 March 2024
*/

public class Product {
    private String name;
    private String productId;
    private Float price;
    private int quantity;
    private String description;
    private String ingredients;
    private Boolean availability;

    private Product(Builder builder){
        this.name = builder.name;
        this.productId = builder.productId;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.description = builder.description;
        this.ingredients = builder.ingredients;
        this.availability = builder.availability;
    }

    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }

    public Float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public Boolean getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productId='" + productId + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", availability=" + availability +
                '}';
    }



    public static class Builder {
        private String name;
        private String productId;
        private Float price;
        private int quantity;
        private String description;
        private String ingredients;
        private Boolean availability;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder setPrice(Float price) {
            this.price = price;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setIngredients(String ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Builder setAvailability(Boolean availability) {
            this.availability = availability;
            return this;
        }

        public Builder copy(Product product){
            this.name = product.name;
            this.productId = product.productId;
            this.price = product.price;
            this.quantity = product.quantity;
            this.description = product.description;
            this.ingredients = product.ingredients;
            this.availability = product.availability;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }

}
