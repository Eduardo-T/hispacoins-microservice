package com.dbchispano.hispacoins.service;

import com.dbchispano.hispacoins.domain.operation.Operation;
import com.dbchispano.hispacoins.processor.OperationProcessor;
import org.springframework.data.repository.CrudRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class BaseOperationService<OP extends Operation> implements OperationService<OP> {

    private final CrudRepository<OP, UUID> REPOSITORY;
    private final Function<OP, OperationProcessor<OP>> SUPPLIER;

    public BaseOperationService(CrudRepository<OP, UUID> repository, Function<OP, OperationProcessor<OP>> processorSupplier) {
        this.REPOSITORY = Objects.requireNonNull(repository);
        this.SUPPLIER = processorSupplier;
    }

    @Override
    public OP createOperation(OP operation) {
        return REPOSITORY.save(operation);
    }

    @Override
    public OperationProcessor<OP> processor(OP operation) {
        return SUPPLIER.apply(operation);
    }

    @Override
    public boolean contains(OP operation) {
        return false;
    }

    @Override
    public Optional<OP> getById(UUID uuid) {
        return REPOSITORY.findById(uuid);
    }

}
