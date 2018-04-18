package edu.kpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private AccountService service;

    @Autowired
    private AccountRep rep;

    @GetMapping("")
    public String main() {
        StringBuilder blr = new StringBuilder();
        blr.append("<a href='/api/accounts'>Find all!</a>");
        blr.append("<br/>");
        blr.append("<a href='/api/accounts/1'>By id: /api/accounts/{id}</a>");

        return blr.toString();
    }

    @GetMapping("accounts")
    public List<AccountDto> getAll() {
        return service.getAllAccounts();
    }

    @GetMapping("accounts/{id}")
    public Account getById(@PathVariable(name = "id") Long id) {
        return rep.findById(id).orElse(null);
    }

    @PutMapping("accounts")
    public void save(@RequestParam AccountDto acc) {
        service.saveNewAccount(acc);
    }

    @PostMapping("accounts/{id}")
    public void update(@PathVariable(name = "id") Long id, @RequestParam AccountDto dto) {
        Account account = new Account();
        account.setAddress(dto.getAddress());
        account.setName(dto.getName());
        account.setAccountId(id);
        service.update(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

}
