package minipro2.order.service;

import minipro2.order.model.ProductOrder;

import java.util.List;

public interface ProductOrderService {
    ProductOrder findById(int id);
    ProductOrder save(ProductOrder productOrder);
    List<ProductOrder> getAll();
}
