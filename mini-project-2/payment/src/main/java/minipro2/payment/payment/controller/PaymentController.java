package minipro2.payment.payment.controller;


import minipro2.payment.payment.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    List<Payment> pmtOptions = Arrays.asList(
            new Payment("Option one Credit Card", "Master Card"),
            new Payment("Option two Paypal ", "PayPal"),
            new Payment("Option three CashUp", "CashUp")

    );

    @GetMapping("/payOptions")
    public PayWraper getPmtOption() {
        PayWraper payWraper = new PayWraper();
        payWraper.setPmtList(pmtOptions);
        return payWraper;
    }

    @GetMapping("/options/{option}")
    public PaymentOption getPayOption(@PathVariable String option) {
        switch (option) {
            case "credit":
                return restTemplate.getForObject("http://localhost:9097/credit", CreditSys.class);
            case "paypal":
                return restTemplate.getForObject("http://localhost:9095/paypal", PayPalSys.class);
            case "cashup":
                return restTemplate.getForObject("http://localhost:9096/cashup", CashUpSys.class);
            default:
                return null;
        }
    }

//    @GetMapping("/paypal")
//    public PayPalSys getPaypal() {
//        return restTemplate.getForObject("http://localhost:9095/paypal", PayPalSys.class);
//    }
//
//    @GetMapping("/cashup")
//    public CashUpSys getCashup() {
//        return restTemplate.getForObject("http://localhost:9096/cashup", CashUpSys.class);
//    }
//
//    @GetMapping("/credit")
//    public CreditSys getCredit() {
//        return restTemplate.getForObject("http://localhost:9097/credit", CreditSys.class);
//    }


}
