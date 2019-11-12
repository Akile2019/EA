package minipro2.account.service;

import minipro2.account.model.Account;
import minipro2.account.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;


    @Override
    public Account create(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public void delet(Account account) {
        accountRepo.delete(account);

    }

    @Override
    public List<Account> displayAll() {
        return accountRepo.findAll();
    }


}
