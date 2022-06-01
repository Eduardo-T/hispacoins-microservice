package com.dbchispano.hispacoins.processor;

import com.dbchispano.hispacoins.domain.operation.Operation;
import com.dbchispano.hispacoins.worker.OperationWorker;

public class BaseOperationProcessor<OP extends Operation> extends AbstractOperationProcessor<OP> {

    public BaseOperationProcessor(OP operation, OperationWorker<OP> worker) {
        super(operation, worker);
    }

}
