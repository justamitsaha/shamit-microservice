package com.saha.amit.jpaApp.repository;

import com.saha.amit.jpaApp.dto.CustomerAccounts;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerAccountsRepository extends CrudRepository<CustomerAccounts, String> {

    List<CustomerAccounts> findCustomerAccountsByCustomerNumber(String customerNumber);

    List<CustomerAccounts> findCustomerAccountsByAccountNumber(String accountNumber);
}
