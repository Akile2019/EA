package minipro2.product.controller;

import minipro2.product.model.Product;
import minipro2.product.model.ProductList;
import minipro2.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ProductList getProducts(){

        List<Product> products = productService.getAll();
        ProductList productList = new ProductList();
        productList.setProduct(products);

        return productList;
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product){
        Product savedProduct = productService.add(product);

        return savedProduct;
    }
}
