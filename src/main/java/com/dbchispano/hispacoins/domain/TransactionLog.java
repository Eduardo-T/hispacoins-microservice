package com.dbchispano.hispacoins.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class TransactionLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private @NonNull Timestamp dateCreated;

    @Column(nullable = false)
    private @NonNull Timestamp dateProcessed;

    @ManyToOne
    @JoinColumn(nullable = false)
    private @Nullable Account remittent;

    @ManyToOne
    @JoinColumn(nullable = false)
    private @Nullable Account beneficiary;

    @Column(nullable = false)
    private @NonNull Long amount;

    public TransactionLog() {
    }

    public UUID getId() {
        return id;
    }

    public @NonNull Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(@NonNull Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public @NonNull Date getDateProcessed() {
        return dateProcessed;
    }

    public void setDateProcessed(@NonNull Timestamp dateProcessed) {
        this.dateProcessed = dateProcessed;
    }

    public @Nullable Account getRemittent() {
        return remittent;
    }

    public void setRemittent(@Nullable Account remittent) {
        this.remittent = remittent;
    }

    public @Nullable Account getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(@Nullable Account beneficiary) {
        this.beneficiary = beneficiary;
    }

    public @NonNull Long getAmount() {
        return amount;
    }

    public void setAmount(@NonNull Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionLog that = (TransactionLog) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!dateCreated.equals(that.dateCreated)) return false;
        if (!dateProcessed.equals(that.dateProcessed)) return false;
        if (remittent != null ? !remittent.equals(that.remittent) : that.remittent != null) return false;
        if (beneficiary != null ? !beneficiary.equals(that.beneficiary) : that.beneficiary != null) return false;
        return amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
