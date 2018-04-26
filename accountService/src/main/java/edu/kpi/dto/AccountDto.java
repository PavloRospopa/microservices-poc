package edu.kpi.dto;

import edu.kpi.persistence.entity.Account;
import lombok.Data;

@Data
public class AccountDto {
    private String name;
    private String address;

    public AccountDto(Account account) {
        setName(account.getName());
        setAddress(account.getAddress());
    }
}
