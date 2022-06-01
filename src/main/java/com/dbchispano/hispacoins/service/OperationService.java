package com.dbchispano.hispacoins.service;

import com.dbchispano.hispacoins.domain.operation.Operation;
import com.dbchispano.hispacoins.processor.OperationProcessor;

import java.util.Optional;
import java.util.UUID;

public interface OperationService<OP extends Operation> {

    OP createOperation(OP operation);

    OperationProcessor<OP> processor(OP operation);

    boolean contains(OP operation);

    Optional<OP> getById(UUID uuid);

}
