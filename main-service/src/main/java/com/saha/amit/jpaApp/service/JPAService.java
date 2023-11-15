package com.saha.amit.jpaApp.service;

import com.saha.amit.jpaApp.dto.CustomerAccounts;
import com.saha.amit.jpaApp.dto.Transactions;
import com.saha.amit.jpaApp.repository.CustomerAccountsRepository;
import com.saha.amit.jpaApp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAService {

    @Autowired
    CustomerAccountsRepository customerAccountsRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public Iterable<CustomerAccounts> getAllAccounts() {
        return customerAccountsRepository.findAll();
    }

    public Iterable<CustomerAccounts> findCustomerAccountsByCustomerNumber(String customerNumber) {
        return customerAccountsRepository.findCustomerAccountsByCustomerNumber(customerNumber);
    }

    public Iterable<CustomerAccounts> findCustomerAccountsByAccountNumber(String accountNumber) {
        return customerAccountsRepository.findCustomerAccountsByAccountNumber(accountNumber);
    }



    public List<Transactions> findTransactionByAccountNumber(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    public List<Transactions> findTransactionsByTransactionID(String transactionID) {
        return transactionRepository.findTransactionsByTransactionID(transactionID);
    }

}