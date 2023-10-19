package com.saha.amit.controller;


import com.saha.amit.dto.CustomerAccounts;
import com.saha.amit.service.CustomerAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configuration")
public class CustomerAccountsController {

    @Autowired
    CustomerAccountsService customerAccountsService;

    @GetMapping("getAllAccounts")
    public Iterable<CustomerAccounts> getAllAccounts(){
        return customerAccountsService.getAllAccounts();
    }
}
