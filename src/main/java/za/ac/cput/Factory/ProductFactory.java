package za.ac.cput.Factory;

/*
    Author: Mohamed Zouheir 221215794
    Date: 27 March 2024
*/

import za.ac.cput.Domain.Product;
import za.ac.cput.Utils.ProductUtils;


public class ProductFactory {
    public static Product buildProduct(String name, Float price, int quantity, String description, String ingredients, Boolean availability){
        if(ProductUtils.isValid(name)
                && ProductUtils.isValid(price)
                && ProductUtils.isValid(description)
                && ProductUtils.isValid(ingredients)
                && ProductUtils.isValid(availability)
        ){
            return new Product.Builder()
                    .setProductId(ProductUtils.generateId())
                    .setName(name)
                    .setPrice(price)
                    .setQuantity(quantity)
                    .setDescription(description)
                    .setIngredients(ingredients)
                    .setAvailability(availability)
                    .build();
        }
        return null;
    }

}
