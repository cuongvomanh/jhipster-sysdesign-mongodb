package com.mycompany.mygroup.service;

import com.mycompany.mygroup.service.dto.BankAccountDTO;
import com.mycompany.mygroup.web.rest.errors.BankAccountBadRequestException;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.mygroup.domain.BankAccount}.
 */
public interface BankAccountService {

    /**
     * Save a bankAccount.
     *
     * @param bankAccountDTO the entity to save.
     * @return the persisted entity.
     */
    BankAccountDTO save(BankAccountDTO bankAccountDTO);

    /**
     * Get all the bankAccounts.
     *
     * @return the list of entities.
     */
    List<BankAccountDTO> findAll();


    /**
     * Get the "id" bankAccount.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BankAccountDTO> findOne(String id);

    /**
     * Delete the "id" bankAccount.
     *
     * @param id the id of the entity.
     */
    void delete(String id);

    ResponseModel withdraw(RequestModel requestModel) throws BankAccountBadRequestException;

    ResponseModel deposit(RequestModel requestModel) throws BankAccountBadRequestException;
}
