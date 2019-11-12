package minipro2.product.service;

import minipro2.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product add(Product product);
}
