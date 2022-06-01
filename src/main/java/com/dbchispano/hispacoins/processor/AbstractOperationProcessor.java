package com.dbchispano.hispacoins.processor;

import com.dbchispano.hispacoins.domain.operation.Operation;
import com.dbchispano.hispacoins.exception.AlreadyProcessedException;
import com.dbchispano.hispacoins.worker.OperationWorker;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class AbstractOperationProcessor<OP extends Operation> implements OperationProcessor<OP> {

    private final OP operation;
    private final OperationWorker<OP> worker;

    protected AbstractOperationProcessor(OP operation, OperationWorker<OP> worker) {
        this.operation = Objects.requireNonNull(operation);
        this.worker = worker;
    }

    @Override
    public OP process() {
        if (operation.getDateProcessed() != null)
            throw new AlreadyProcessedException();

        this.worker.perform(operation);
        operation.setDateProcessed(Timestamp.from(Instant.now()));

        // TODO transaction logging

        return operation;
    }
}
