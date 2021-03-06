package com.dbchispano.hispacoins.service;

import com.dbchispano.hispacoins.domain.Account;
import com.dbchispano.hispacoins.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository ACCOUNT_REPOSITORY;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.ACCOUNT_REPOSITORY = accountRepository;
    }

    @Override
    public Account createAccount(String nick) {
        Account account = new Account();
        account.setNick(nick);
        return createAccount(account);
    }

    @Override
    public Account createAccount(Account account) {
        return ACCOUNT_REPOSITORY.findByNick(account.getNick()).or(() -> ACCOUNT_REPOSITORY.findById(account.getId() == null ? UUID.randomUUID() : account.getId())).orElseGet(() -> ACCOUNT_REPOSITORY.save(account));
    }

    @Override
    public Iterable<Account> getAll() {
        return ACCOUNT_REPOSITORY.findAll();
    }

    @Override
    public Optional<Account> get(UUID uuid) {
        return ACCOUNT_REPOSITORY.findById(uuid);
    }

    @Override
    public Optional<Account> get(String nick) {
        return ACCOUNT_REPOSITORY.findByNick(nick);
    }

}
