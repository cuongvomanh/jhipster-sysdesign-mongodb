package com.mycompany.mygroup.service.mapper;


import com.mycompany.mygroup.domain.*;
import com.mycompany.mygroup.service.dto.BankAccountDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BankAccount} and its DTO {@link BankAccountDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BankAccountMapper extends EntityMapper<BankAccountDTO, BankAccount> {



    default BankAccount fromId(String id) {
        if (id == null) {
            return null;
        }
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(id);
        return bankAccount;
    }
}
