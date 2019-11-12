package minipro2.order.service.serviceImpl;

import minipro2.order.model.ProductOrder;
import minipro2.order.repositories.ProductOrderRepo;
import minipro2.order.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    ProductOrderRepo productOrderRepo;


    @Override
    public ProductOrder findById(int id) {
        return productOrderRepo.findById(id).get();
    }

    @Override
    public ProductOrder save(ProductOrder productOrder) {
        return productOrderRepo.save(productOrder);
    }

    @Override
    public List<ProductOrder> getAll() {
        return productOrderRepo.findAll();
    }
}
