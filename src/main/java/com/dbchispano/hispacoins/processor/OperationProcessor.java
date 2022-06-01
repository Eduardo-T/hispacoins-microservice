package com.dbchispano.hispacoins.processor;

import com.dbchispano.hispacoins.domain.operation.Operation;

public interface OperationProcessor<OP extends Operation> {

    OP process();

}
