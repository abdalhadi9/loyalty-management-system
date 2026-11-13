package com.abdalhadi9.loyalty_management_system.controller;

import com.abdalhadi9.loyalty_management_system.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerControlle {
    private final CustomerService customerService;

    public CustomerControlle(CustomerService customerService) {
        this.customerService = customerService;
    }
}

