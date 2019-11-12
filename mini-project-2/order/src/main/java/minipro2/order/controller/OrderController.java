package minipro2.order.controller;

import minipro2.order.model.*;
import minipro2.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public List<Order1> getOrders()
    {
        return orderService.getAll();
    }

    @GetMapping("/products")
    public ProductList getProducts()
    {
        ProductList products = restTemplate.getForObject("http://localhost:9090/products/", ProductList.class);

        return products;
    }

    @PostMapping("/add/{payOption}")
    public HashMap<String, Object> addOrder(@RequestBody List<Product> products, @PathVariable String payOption){

        PaymentOption paymentOption = new PaymentOption();
        paymentOption = restTemplate.getForObject("http://localhost:9098/payments/options/"+payOption, PaymentOption.class);

        Order1 order1 = new Order1();
        Date orderDate = new Date();
        order1.setOrderDate(orderDate);

        Order1 savedOrder = orderService.save(order1, products);

        HashMap<String, Object> result = new HashMap<>();

        result.put("Order", savedOrder);
        result.put("Payment", paymentOption);

        return result;
    }

    //payment option


    @GetMapping("/paymentoptions")

    public PayWraper getOptions(){
        return restTemplate.getForObject("http://localhost:9098/payment/options",PayWraper.class);
    }

    @GetMapping("/cashup")

    public CashUpSys getCashUp(){
        return restTemplate.getForObject("http://localhost:9096/payment/cashup",CashUpSys.class);
    }

    @GetMapping("/paypal")

    public PayPalSys getPayPal(){
        return restTemplate.getForObject("http://localhost:9095/payment/paypal",PayPalSys.class);
    }
}
