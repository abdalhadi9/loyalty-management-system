package com.abdalhadi9.loyalty_management_system.controller;

import com.abdalhadi9.loyalty_management_system.entity.Customer;
import com.abdalhadi9.loyalty_management_system.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> register(@RequestBody @Valid Customer customer) {
        Customer Saved = customerService.registerCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(Saved);
    }
}


