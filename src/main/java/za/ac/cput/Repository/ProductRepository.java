package za.ac.cput.Repository;

import za.ac.cput.Domain.Admin;
import za.ac.cput.Domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository<Product, String> {
    private final List<Product> list = new ArrayList();

    @Override
    public Product create(Product object) {
        list.add(object);
        return object;
    }

    @Override
    public Product read(String id) {
        for(Product product: list){
            if(product.getProductId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product update(Product object) {
        for(Product product: list){
            if(product.getProductId().equals(object.getProductId())){
                list.remove(product);
                list.add(object);
                return object;
            }
        }
        return null;
    }

    @Override
    public Product delete(String id) {
        for(Product product: list){
            if(product.getProductId().equals(id)){
                list.remove(product);
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return list;
    }
}
