package com.dbchispano.hispacoins.repository;

import com.dbchispano.hispacoins.domain.operation.Operation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface OperationRepository<OP extends Operation> extends CrudRepository<OP, UUID> {
}
