package com.mycompany.mygroup.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.mycompany.mygroup.domain.BankAccount} entity.
 */
public class BankAccountDTO implements Serializable {

    private String id;

    @NotNull
    @Size(min = 5, max = 20)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String number;

    private BigDecimal balance;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BankAccountDTO)) {
            return false;
        }

        return id != null && id.equals(((BankAccountDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BankAccountDTO{" +
            "id=" + getId() +
            ", number='" + getNumber() + "'" +
            ", balance=" + getBalance() +
            "}";
    }

}
