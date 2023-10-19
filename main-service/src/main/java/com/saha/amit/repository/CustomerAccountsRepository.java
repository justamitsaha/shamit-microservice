package com.saha.amit.repository;

import com.saha.amit.dto.CustomerAccounts;
import org.springframework.data.repository.CrudRepository;

public interface CustomerAccountsRepository extends CrudRepository<CustomerAccounts,String> {
}
