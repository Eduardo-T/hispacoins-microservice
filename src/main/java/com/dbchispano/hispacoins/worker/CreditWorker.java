package com.dbchispano.hispacoins.worker;

import com.dbchispano.hispacoins.annotation.Worker;
import com.dbchispano.hispacoins.domain.Account;
import com.dbchispano.hispacoins.domain.operation.CreditOperation;
import com.dbchispano.hispacoins.repository.CreditRepository;

import java.sql.Timestamp;
import java.time.Instant;

@Worker
public class CreditWorker implements OperationWorker<CreditOperation> {

    private final CreditRepository REPOSITORY;

    public CreditWorker(CreditRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public void perform(CreditOperation operation) {
        Account to = operation.getTo();
        long amount = operation.getAmount();

        to.setBalance(to.getBalance() + amount);

        operation.setDateProcessed(Timestamp.from(Instant.now()));

        REPOSITORY.save(operation);
    }
}
