package com.dbchispano.hispacoins.repository;

import com.dbchispano.hispacoins.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<Account, UUID> {

    Optional<Account> findByNick(String nick);

}
