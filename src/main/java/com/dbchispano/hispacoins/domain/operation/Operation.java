package com.dbchispano.hispacoins.domain.operation;

import java.sql.Timestamp;
import java.util.Date;

public interface Operation {

    //TransactionLog getTransaction();

    Long getAmount();

    Date getDateCreated();

    void setDateCreated(Timestamp timestamp);

    Date getDateProcessed();

    void setDateProcessed(Timestamp timestamp);


}
