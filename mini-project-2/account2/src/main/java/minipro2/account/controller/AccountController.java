package minipro2.account.controller;


import minipro2.account.model.Account;
import minipro2.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("/")
    public List<Account> getAll(){
        return accountService.displayAll();
    }


    @PostMapping("/add")
    public Account addNew(@RequestBody Account account){
        Account addedAcc = accountService.create(account);
        return addedAcc;
    }
}
