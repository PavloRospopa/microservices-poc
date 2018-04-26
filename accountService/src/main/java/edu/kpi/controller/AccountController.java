package edu.kpi.controller;

import edu.kpi.dto.AccountDto;
import edu.kpi.persistence.entity.Account;
import edu.kpi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping
    public List<AccountDto> getAll() {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AccountDto accountDto) {
        Account created = service.create(accountDto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(created.getAccountId()).toUri();

        return ResponseEntity.created(location).body(new AccountDto(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AccountDto dto) {
        Account account = new Account();
        account.setAccountId(id);
        account.setName(dto.getName());
        account.setAddress(dto.getAddress());

        Account update = service.update(account);

        return ResponseEntity.ok(new AccountDto(update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
