package minipro2.payPal.payPal.controller;


import minipro2.payPal.payPal.model.PayPalSys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PayPalController {

    @GetMapping("/paypal")
    public PayPalSys getPayPal(){
        PayPalSys payPalSys = new PayPalSys();
        payPalSys.setMsg("PayPal Payment Option!!");
        return payPalSys;
    }

}
