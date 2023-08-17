package com.sirotina.bankapp.service;

import com.sirotina.bankapp.entity.Transaction;
import com.sirotina.bankapp.service.exception.TransactionNotFoundException;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    List<Transaction> getAll();
    Transaction getTransactionById(UUID id);
    void createTransaction(Transaction transaction);
    void deleteTransactionById(UUID id) throws TransactionNotFoundException;
}
