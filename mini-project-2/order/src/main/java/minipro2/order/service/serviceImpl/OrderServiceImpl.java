package minipro2.order.service.serviceImpl;

import minipro2.order.model.Order1;
import minipro2.order.model.Product;
import minipro2.order.model.ProductOrder;
import minipro2.order.repositories.OrderRepo;
import minipro2.order.repositories.ProductOrderRepo;
import minipro2.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
 {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProductOrderRepo productOrderRepo;

     @Override
     public Order1 findById(int id) {
         return orderRepo.getOne(id);
     }

     @Override
     public Order1 save(Order1 Order1, List<Product> products) {
         Order1 order1 = orderRepo.save(Order1);

         for (Product product : products){

             ProductOrder productOrder = new ProductOrder(0, order1.getId(), product.getId());

             productOrderRepo.save(productOrder);
         }

         return order1;
     }

     @Override
    public List<Order1> getAll() {
        return orderRepo.findAll();
    }
}
