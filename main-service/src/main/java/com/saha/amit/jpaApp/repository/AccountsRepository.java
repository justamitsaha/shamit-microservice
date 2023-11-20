package com.saha.amit.jpaApp.repository;

import com.saha.amit.jpaApp.dto.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Accounts, String> {

}
