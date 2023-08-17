package com.sirotina.bankapp.service.impl;

import com.sirotina.bankapp.entity.Transaction;
import com.sirotina.bankapp.mapper.TransactionMapper;
import com.sirotina.bankapp.repository.AccountRepository;
import com.sirotina.bankapp.repository.TransactionRepository;
import com.sirotina.bankapp.service.TransactionService;
import com.sirotina.bankapp.service.exception.AccountNotFoundException;
import com.sirotina.bankapp.service.exception.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

    @Override
    public List<Transaction> getAll() {
        for(Transaction dto : transactionRepository.findAll()) {
            System.out.println(dto.toString());
        }
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(UUID id) {
        return transactionRepository.findTransactionById(id).get();
    }

    @Override
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransactionById(UUID id) {
        transactionRepository.deleteById(id);
    }
}
