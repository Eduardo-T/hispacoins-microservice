package com.dbchispano.hispacoins.worker;

import com.dbchispano.hispacoins.annotation.Worker;
import com.dbchispano.hispacoins.domain.Account;
import com.dbchispano.hispacoins.domain.operation.TransferOperation;
import com.dbchispano.hispacoins.exception.NotEnoughBalanceException;
import com.dbchispano.hispacoins.repository.TransferRepository;

import java.sql.Timestamp;
import java.time.Instant;

@Worker
public class TransferWorker implements OperationWorker<TransferOperation> {

    private final TransferRepository REPOSITORY;

    public TransferWorker(TransferRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public void perform(TransferOperation operation) {
        Account from = operation.getRemittent();
        Account to = operation.getBeneficiary();
        long amount = operation.getAmount();

        if (from.getBalance() < amount)
            throw new NotEnoughBalanceException();

        to.setBalance(to.getBalance() + amount);
        from.setBalance(from.getBalance() - amount);

        operation.setDateProcessed(Timestamp.from(Instant.now()));

        REPOSITORY.save(operation);
    }
}
