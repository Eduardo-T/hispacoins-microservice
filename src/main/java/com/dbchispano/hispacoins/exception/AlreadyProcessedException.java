package com.dbchispano.hispacoins.exception;

public class AlreadyProcessedException extends OperationProcessException {

    public AlreadyProcessedException() {
        super("The given operation was already processed");
    }
}
