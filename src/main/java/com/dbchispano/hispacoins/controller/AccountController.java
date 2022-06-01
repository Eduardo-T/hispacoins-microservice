package com.dbchispano.hispacoins.controller;

import com.dbchispano.hispacoins.domain.Account;
import com.dbchispano.hispacoins.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService SERVICE;

    public AccountController(AccountService accountService) {
        this.SERVICE = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return SERVICE.createAccount(account);
    }

    @GetMapping
    public Optional<Account> getAccount(@RequestParam UUID uuid) {
        return SERVICE.get(uuid);
    }

    @GetMapping("/all")
    public Iterable<Account> all() {
        return SERVICE.getAll();
    }


}
