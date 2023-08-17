package com.sirotina.bankapp.service;

import com.sirotina.bankapp.entity.Account;
import com.sirotina.bankapp.entity.enums.AccountStatus;
import java.util.List;
import java.util.UUID;


public interface AccountService {

    List<Account> findAllAccountsByStatus(AccountStatus status);

    List<Account> findAllAccounts();


//    public AccountDTO addNewAccount(AccountDTO accountDTO);

    Account addNewAccount(Account accountDTO);

    Account editAccountById(UUID id, Account accountDTO);

    void deleteById(UUID id);


}
