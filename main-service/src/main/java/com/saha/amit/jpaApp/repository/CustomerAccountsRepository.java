package com.saha.amit.jpaApp.repository;

import com.saha.amit.jpaApp.dto.CustomerAccounts;
import org.springframework.data.repository.CrudRepository;

public interface CustomerAccountsRepository extends CrudRepository<CustomerAccounts, String> {
}
