package com.mycompany.mygroup.service.impl;

import com.mycompany.mygroup.config.BankAccountMessageConstant;
import com.mycompany.mygroup.service.BankAccountService;
import com.mycompany.mygroup.domain.BankAccount;
import com.mycompany.mygroup.repository.BankAccountRepository;
import com.mycompany.mygroup.service.RequestModel;
import com.mycompany.mygroup.service.ResponseModel;
import com.mycompany.mygroup.service.dto.BankAccountDTO;
import com.mycompany.mygroup.service.mapper.BankAccountMapper;
import com.mycompany.mygroup.web.rest.errors.BankAccountBadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link BankAccount}.
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final Logger log = LoggerFactory.getLogger(BankAccountServiceImpl.class);

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Autowired
    private BankAccountMessageConstant bankAccountMessageConstant;

    public BankAccountServiceImpl(){

    }

    /**
     * Save a bankAccount.
     *
     * @param bankAccountDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BankAccountDTO save(BankAccountDTO bankAccountDTO) {
        log.debug("Request to save BankAccount : {}", bankAccountDTO);
        BankAccount bankAccount = bankAccountMapper.toEntity(bankAccountDTO);
        bankAccount = bankAccountRepository.save(bankAccount);
        return bankAccountMapper.toDto(bankAccount);
    }

    /**
     * Get all the bankAccounts.
     *
     * @return the list of entities.
     */
    @Override
    public List<BankAccountDTO> findAll() {
        log.debug("Request to get all BankAccounts");
        return bankAccountRepository.findAll().stream()
            .map(bankAccountMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one bankAccount by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<BankAccountDTO> findOne(String id) {
        log.debug("Request to get BankAccount : {}", id);
        return bankAccountRepository.findById(id)
            .map(bankAccountMapper::toDto);
    }

    /**
     * Delete the bankAccount by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete BankAccount : {}", id);
        bankAccountRepository.deleteById(id);
    }

    @Override
    public ResponseModel withdraw(RequestModel requestModel) throws BankAccountBadRequestException {
        BankAccount account = bankAccountRepository.getByNumber(requestModel.getAccountNumber());
        boolean withdrawResult = account.withdraw(requestModel.getAmmount());
        ResponseModel response = new ResponseModel();
        if (withdrawResult) {
            bankAccountRepository.save(account);
            response.setResult(bankAccountMessageConstant.getWithdrawSuccessful());
//            this.bankAccountPresentBoundary.accept();
            return response;
        } else {
            throw new BankAccountBadRequestException(bankAccountMessageConstant.getWithdrawFailed());
        }
    }

    @Override
    public ResponseModel deposit(RequestModel requestModel) throws BankAccountBadRequestException {
        BankAccount account = bankAccountRepository.getByNumber(requestModel.getAccountNumber());
        boolean depositResult = account.deposit(requestModel.getAmmount());
        ResponseModel response = new ResponseModel();
        if (depositResult) {
            bankAccountRepository.save(account);
            response.setResult(bankAccountMessageConstant.getDepositSuccessful());
            return response;
        } else {
            throw new BankAccountBadRequestException(bankAccountMessageConstant.getDepositFailed());
        }
    }
}
