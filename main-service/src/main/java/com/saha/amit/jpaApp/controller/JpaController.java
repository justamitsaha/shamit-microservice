package com.saha.amit.jpaApp.controller;


import com.saha.amit.jpaApp.dto.Accounts;
import com.saha.amit.jpaApp.dto.Student;
import com.saha.amit.jpaApp.dto.Transactions;
import com.saha.amit.jpaApp.service.JPAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class JpaController {

    Logger logger = LoggerFactory.getLogger(JpaController.class);
    static int i = 0;
    @Autowired
    JPAService jpaService;

    JpaController() {
        i++;
        logger.info("JpaController initialization "+i);
    }

    public JpaController(JPAService jpaService) {
        this.jpaService = jpaService;
        i++;
        logger.info("JpaController initialization "+i);
    }

    @GetMapping("findTransactionByAccountNumber/{accountNumber}")
    public ResponseEntity<List<Transactions>> findTransactionByAccountNumber(@PathVariable String accountNumber) {
        return ResponseEntity.status(HttpStatus.FOUND).body(jpaService.findTransactionByAccountNumber(accountNumber));
    }

    @GetMapping("findTransactionsByTransactionID/{transactionID}")
    public ResponseEntity<List<Transactions>> findTransactionsById(@PathVariable String transactionID) {
        return ResponseEntity.status(HttpStatus.FOUND).body(jpaService.findTransactionsByTransactionID(transactionID));
    }
}
