package com.saha.amit.service;

import com.saha.amit.dto.CustomerAccounts;
import com.saha.amit.repository.CustomerAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerAccountsService {

    @Autowired
    CustomerAccountsRepository customerAccountsRepository;
    public Iterable<CustomerAccounts> getAllAccounts(){
        return customerAccountsRepository.findAll();
    }

}
