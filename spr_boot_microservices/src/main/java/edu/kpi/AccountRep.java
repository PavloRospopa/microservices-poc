package edu.kpi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRep extends CrudRepository<Account, Long> {
    List<Account> findAll();

    List<Account> findByName(String name);
}
