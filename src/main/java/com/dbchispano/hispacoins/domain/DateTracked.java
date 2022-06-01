package com.dbchispano.hispacoins.domain;

import java.sql.Timestamp;

public interface DateTracked {

    Timestamp getDateCreated();

    Timestamp getDateProcessed();

}
