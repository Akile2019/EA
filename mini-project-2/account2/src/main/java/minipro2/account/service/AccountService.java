package minipro2.account.service;

import minipro2.account.model.Account;

import java.util.List;

public interface AccountService {

    Account create(Account account);
    void delet(Account account);
    List<Account> displayAll();


}
