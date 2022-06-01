package com.dbchispano.hispacoins.domain.operation;

import com.dbchispano.hispacoins.domain.AbstractEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.time.Instant;

@MappedSuperclass
public abstract class AbstractOperation extends AbstractEntity implements Operation {

    // TODO: remove this
    //@OneToOne
    //private @NonNull TransactionLog transactionLog;

    @Column(nullable = false, columnDefinition = "bigint default 0")
    private @NonNull Long amount;

    @Column(nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private @NonNull Timestamp dateCreated;
    @Column(nullable = true)
    @Nullable
    private Timestamp dateProcessed;

    protected AbstractOperation() {
        this.dateCreated = Timestamp.from(Instant.now());
    }

    protected AbstractOperation(@NonNull Long amount) {
        this();
        this.amount = amount;
    }

    //@Override
    //public TransactionLog getTransaction() {
    //    return transactionLog;
    //}

    //public void setTransaction(@NonNull TransactionLog transactionLog) {
    //    this.transactionLog = transactionLog;
    //}

    @Override
    public Long getAmount() {
        return amount;
    }

    @Override
    @NonNull
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    @Override
    public void setDateCreated(@NonNull Timestamp dateProcessed) {
        this.dateCreated = dateCreated;
    }

    @Override
    @Nullable
    public Timestamp getDateProcessed() {
        return dateProcessed;
    }

    @Override
    public void setDateProcessed(@Nullable Timestamp dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractOperation)) return false;
        if (!super.equals(o)) return false;

        AbstractOperation that = (AbstractOperation) o;

        if (!getAmount().equals(that.getAmount())) return false;
        if (!getDateCreated().equals(that.getDateCreated())) return false;
        return getDateProcessed() != null ? getDateProcessed().equals(that.getDateProcessed()) : that.getDateProcessed() == null;
    }

}
