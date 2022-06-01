package com.dbchispano.hispacoins.exception;

public class NotEnoughBalanceException extends OperationProcessException {

    public NotEnoughBalanceException() {
        super("The given account has not enough balance");
    }

}
