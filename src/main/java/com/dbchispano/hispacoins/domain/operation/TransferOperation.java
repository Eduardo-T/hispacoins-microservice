package com.dbchispano.hispacoins.domain.operation;

import com.dbchispano.hispacoins.domain.Account;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transfers")
public class TransferOperation extends AbstractOperation {

    @JoinColumn(nullable = false)
    @ManyToOne
    private @NonNull Account remittent;

    @JoinColumn(nullable = false)
    @ManyToOne
    private @NonNull Account beneficiary;

    public TransferOperation(long amount, @NonNull Account remittent, @NonNull Account beneficiary) {
        super(amount);
        this.remittent = remittent;
        this.beneficiary = beneficiary;
    }

    public TransferOperation() {
        super();
    }

    @NonNull
    public Account getRemittent() {
        return remittent;
    }

    @NonNull
    public Account getBeneficiary() {
        return beneficiary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransferOperation)) return false;
        if (!super.equals(o)) return false;

        TransferOperation that = (TransferOperation) o;

        if (!getRemittent().equals(that.getRemittent())) return false;
        return getBeneficiary().equals(that.getBeneficiary());
    }

}
