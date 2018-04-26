package edu.kpi.service;

import edu.kpi.dto.AccountDto;
import edu.kpi.persistence.entity.Account;
import edu.kpi.persistence.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account create(AccountDto dto) {
        Account account = new Account();
        account.setAddress(dto.getAddress());
        account.setName(dto.getName());
        return repository.save(account);
    }

    public Account update(Account account) {
        return repository.save(account);
    }

    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = repository.findAll();
        return accounts.stream()
                .map(AccountDto::new)
                .collect(Collectors.toList());
    }

    public List<AccountDto> findByName(String name) {
        List<Account> accounts = repository.findByName(name);
        return accounts.stream()
                .map(AccountDto::new)
                .collect(Collectors.toList());
    }

    public Optional<AccountDto> findById(Long id) {
        return repository.findById(id).map(AccountDto::new);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
