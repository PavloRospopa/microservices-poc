package edu.kpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRep accountRep;

    public Account saveNewAccount(AccountDto dto) {
        Account account = new Account();
        account.setAddress(dto.getAddress());
        account.setName(dto.getName());
        return accountRep.save(account);
    }

    public Account update(Account account) {
        return accountRep.save(account);
    }

    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRep.findAll();
        return accounts.stream().map(AccountDto::new).collect(Collectors.toList());
    }

    public List<AccountDto> findByName(String name) {
        List<Account> accounts = accountRep.findByName(name);
        return accounts.stream().map(AccountDto::new).collect(Collectors.toList());
    }

    public AccountDto findById(Long id) {
        return new AccountDto(accountRep.findById(id).get());
    }


    public void delete(Long id) {
        Account acc = new Account();
        acc.setAccountId(id);
        accountRep.delete(acc);
    }

    public void updateAccount(Account account) {
        accountRep.save(account);
    }
}
