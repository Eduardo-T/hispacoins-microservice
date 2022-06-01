package com.dbchispano.hispacoins.worker;

import com.dbchispano.hispacoins.annotation.Worker;
import com.dbchispano.hispacoins.domain.Account;
import com.dbchispano.hispacoins.domain.ShopItem;
import com.dbchispano.hispacoins.domain.operation.PurchaseOperation;
import com.dbchispano.hispacoins.exception.NotEnoughBalanceException;
import com.dbchispano.hispacoins.repository.PurchaseRepository;

import java.sql.Timestamp;
import java.time.Instant;

@Worker
public class PurchaseWorker implements OperationWorker<PurchaseOperation> {

    private final PurchaseRepository REPOSITORY;

    public PurchaseWorker(PurchaseRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public void perform(PurchaseOperation operation) {
        Account buyer = operation.getBuyer();
        ShopItem item = operation.getPurchase();
        long amount = operation.getAmount();

        if (buyer.getBalance() < amount)
            throw new NotEnoughBalanceException();

        buyer.setBalance(buyer.getBalance() - amount);

        operation.setDateProcessed(Timestamp.from(Instant.now()));

        REPOSITORY.save(operation);
    }
}
