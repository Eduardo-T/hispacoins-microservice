package com.dbchispano.hispacoins.domain.operation;

import com.dbchispano.hispacoins.domain.Account;
import com.dbchispano.hispacoins.domain.ShopItem;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
public class PurchaseOperation extends AbstractOperation {

    @ManyToOne
    @JoinColumn(nullable = false)
    @NonNull
    private Account buyer;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NonNull
    private ShopItem purchase;

    public PurchaseOperation(@NonNull Account buyer, @NonNull ShopItem purchase) {
        super(purchase.getPrice());
        this.buyer = buyer;
        this.purchase = purchase;
    }

    @NonNull
    public Account getBuyer() {
        return buyer;
    }

    public void setBuyer(@NonNull Account buyer) {
        this.buyer = buyer;
    }

    @NonNull
    public ShopItem getPurchase() {
        return purchase;
    }

    public void setPurchase(@NonNull ShopItem purchase) {
        this.purchase = purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseOperation)) return false;
        if (!super.equals(o)) return false;

        PurchaseOperation that = (PurchaseOperation) o;

        if (!getBuyer().equals(that.getBuyer())) return false;
        return getPurchase().equals(that.getPurchase());
    }

}
