package com.dbchispano.hispacoins.domain.operation;

import com.dbchispano.hispacoins.domain.Account;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credits")
public class CreditOperation extends AbstractOperation {

    @ManyToOne
    @JoinColumn(nullable = false)
    private @NonNull Account to;

    public CreditOperation(Long amount, @NonNull Account to) {
        super(amount);
        this.to = to;
    }

    public CreditOperation() {
        super();
    }

    @NonNull
    public Account getTo() {
        return to;
    }

    public void setTo(@NonNull Account to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditOperation)) return false;
        if (!super.equals(o)) return false;

        CreditOperation that = (CreditOperation) o;

        return getTo().equals(that.getTo());
    }

}
