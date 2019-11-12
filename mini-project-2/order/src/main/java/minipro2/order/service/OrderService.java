package minipro2.order.service;

import minipro2.order.model.Order1;
import minipro2.order.model.Product;

import java.util.List;

public interface OrderService {
    Order1 findById(int id);
    Order1 save(Order1 Order1, List<Product> products);
    List<Order1> getAll();
}
