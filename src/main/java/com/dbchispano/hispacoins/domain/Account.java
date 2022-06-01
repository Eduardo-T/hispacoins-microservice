package com.dbchispano.hispacoins.domain;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "accounts")
public class Account extends AbstractEntity implements Serializable {

    @NonNull
    @Column(nullable = false)
    private String nick;

    @NonNull
    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long balance;

    public Account(@NonNull String nick, @NonNull Long balance) {
        super();
        this.nick = nick;
        this.balance = balance;
    }

    public Account(@NonNull String nick) {
        super();
        this.nick = nick;
    }

    public Account() {
        super();
    }

    @NonNull
    public String getNick() {
        return nick;
    }

    public void setNick(@NonNull String nick) {
        this.nick = nick;
    }

    @NonNull
    public Long getBalance() {
        return balance;
    }

    public void setBalance(@NonNull Long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        if (!super.equals(o)) return false;

        Account account = (Account) o;

        if (!getNick().equals(account.getNick())) return false;
        return getBalance().equals(account.getBalance());
    }

}
