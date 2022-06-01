package com.dbchispano.hispacoins.repository;

import com.dbchispano.hispacoins.domain.operation.TransferOperation;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends OperationRepository<TransferOperation> {
}
