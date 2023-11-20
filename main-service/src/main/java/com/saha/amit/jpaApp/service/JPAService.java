package com.saha.amit.jpaApp.service;

import com.saha.amit.jpaApp.dto.Transactions;
import com.saha.amit.jpaApp.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAService {
    @Autowired
    TransactionRepository transactionRepository;

    Logger log = LoggerFactory.getLogger(JPAService.class);


    public List<Transactions> findTransactionByAccountNumber(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    public List<Transactions> findTransactionsByTransactionID(String transactionID) {
        return transactionRepository.findTransactionsByTransactionID(transactionID);
    }

}
