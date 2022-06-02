package com.dbchispano.hispacoins.service;

import com.dbchispano.hispacoins.domain.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountService {

    Account createAccount(String nick);

    Account createAccount(Account account);

    Iterable<Account> getAll();

    Optional<Account> get(UUID uuid);

    Optional<Account> get(String nick);

}
