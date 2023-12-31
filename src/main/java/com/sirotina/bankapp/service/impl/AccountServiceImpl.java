package com.sirotina.bankapp.service.impl;

import com.sirotina.bankapp.entity.Account;
import com.sirotina.bankapp.entity.enums.AccountStatus;
import com.sirotina.bankapp.entity.enums.CurrencyCode;
import com.sirotina.bankapp.mapper.AccountMapper;
import com.sirotina.bankapp.repository.AccountRepository;
import com.sirotina.bankapp.service.AccountService;
import com.sirotina.bankapp.service.exception.AccountExistException;
import com.sirotina.bankapp.service.exception.AccountNotFoundException;
import com.sirotina.bankapp.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<Account> findAllAccountsByStatus(AccountStatus status) {
        return repository.findAllByStatus(status).
                orElseThrow(
                        () -> new AccountNotFoundException
                                ((ErrorMessage.ACCOUNT_NOT_FOUND_BY_STATUS))));
    }

    @Override
    public List<Account> findAllAccounts() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Account addNewAccount(Account accountDTO) {
        String nickname = accountDTO.getNickname();
        checkAccountExist(nickname);

        Account account = new Account();
        account.setId(UUID.randomUUID());
        account.setNickname(accountDTO.getNickname());
        account.setType(accountDTO.getType());
        account.setStatus(accountDTO.getStatus());
        account.setBalance(accountDTO.getBalance());
        account.setCurrencyCode(CurrencyCode.valueOf(String.valueOf(accountDTO.getCurrencyCode())));
        account.setCreatedAt(accountDTO.getCreatedAt());
        account.setUpdatedAt(accountDTO.getUpdatedAt());

        Account savedAccount = repository.save(account);
        return savedAccount;
    }

    private void checkAccountExist(String nickname){
        Account existAccount = repository.findByNickname(nickname);
        if (existAccount != null)
            throw new AccountExistException("The account with the same firstName and lastName already exists");
    }

    @Override
    public Account editAccountById(UUID id, Account accountDTO) {
        Account account = repository.findById(id).orElseThrow(
                () -> new AccountNotFoundException(ErrorMessage.ACCOUNT_NOT_FOUND_BY_ID)
        );

        account.setNickname(accountDTO.getNickname());
        account.setStatus(accountDTO.getStatus());
        account.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        Account result = repository.save(account);
        return result;
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

}
