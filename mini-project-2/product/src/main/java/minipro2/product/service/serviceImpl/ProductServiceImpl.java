package minipro2.product.service.serviceImpl;

import minipro2.product.Repositories.ProductRepo;
import minipro2.product.model.Product;
import minipro2.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product add(Product product) {
        return productRepo.save(product);
    }
}
