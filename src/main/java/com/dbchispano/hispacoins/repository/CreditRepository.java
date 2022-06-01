package com.dbchispano.hispacoins.repository;

import com.dbchispano.hispacoins.domain.operation.CreditOperation;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends OperationRepository<CreditOperation> {
}
