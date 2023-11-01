package com.saha.amit.repository;

import com.saha.amit.dto.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transactions, String> {

    List<Transactions> findByAccountNumber(String accountNumber);

    List<Transactions> findTransactionsByTransactionID(String transactionID);
}
