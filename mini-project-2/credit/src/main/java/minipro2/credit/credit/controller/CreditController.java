package minipro2.credit.credit.controller;


import minipro2.credit.credit.model.CreditSys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditController {

    @GetMapping("/credit")
    public CreditSys getCreditSys(){
        CreditSys creditSys = new CreditSys();
        creditSys.setMsg("Credit card payment system !!");
        return creditSys;
    }
}
