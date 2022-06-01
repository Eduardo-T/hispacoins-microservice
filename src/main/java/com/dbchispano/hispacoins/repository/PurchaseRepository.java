package com.dbchispano.hispacoins.repository;

import com.dbchispano.hispacoins.domain.operation.PurchaseOperation;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends OperationRepository<PurchaseOperation> {
}
