package minipro2.cashUp.cashUp.controller;


import minipro2.cashUp.cashUp.model.CashUpSys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashUpController {

    @GetMapping("/cashup")
    public CashUpSys getCashUp(){
        CashUpSys cashUpSys = new CashUpSys();
        cashUpSys.setMsg("Cash up Payment System !!");
        return cashUpSys;
    }
}
