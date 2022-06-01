package com.dbchispano.hispacoins.worker;

import com.dbchispano.hispacoins.domain.operation.Operation;

public interface OperationWorker<OP extends Operation> {

    /**
     * Performs the required transaction for the given operation, updating its processed date if succeeded.
     *
     * @param operation the operation to perform
     */
    void perform(OP operation);

}
