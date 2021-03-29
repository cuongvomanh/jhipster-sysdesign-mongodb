package com.mycompany.mygroup.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A BankAccount.
 */
@Document(collection = "bank_account")
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Size(min = 5, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @Field("number")
    private String number;

    @Field("balance")
    private BigDecimal balance;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public BankAccount number(String number) {
        this.number = number;
        return this;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BankAccount balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BankAccount)) {
            return false;
        }
        return id != null && id.equals(((BankAccount) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BankAccount{" +
            "id=" + getId() +
            ", number='" + getNumber() + "'" +
            ", balance=" + getBalance() +
            "}";
    }

    public boolean withdraw(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(this.balance) > 0) {
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }
    public boolean deposit(BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        balance = balance.add(amount);
        return true;
    }
}
