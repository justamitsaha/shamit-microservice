package com.saha.amit.jpaApp.controller;


import com.saha.amit.jpaApp.dto.CustomerAccounts;
import com.saha.amit.jpaApp.dto.Transactions;
import com.saha.amit.jpaApp.service.JPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    JPAService jpaService;

    @GetMapping("getAllAccounts")
    public Iterable<CustomerAccounts> getAllAccounts() {
        return jpaService.getAllAccounts();
    }

    @GetMapping("findByAccountNumber/{accountNumber}")
    public ResponseEntity<List<Transactions>> getAccountTransactions(@PathVariable String accountNumber) {
        return ResponseEntity.status(HttpStatus.FOUND).body(jpaService.findByAccountNumber(accountNumber));
    }

    @GetMapping("findTransactionsByTransactionID/{transactionID}")
    public ResponseEntity<List<Transactions>> findTransactionsById(@PathVariable String transactionID) {
        return ResponseEntity.status(HttpStatus.FOUND).body(jpaService.findTransactionsByTransactionID(transactionID));
    }
}
