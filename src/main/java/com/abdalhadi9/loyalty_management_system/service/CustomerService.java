package com.abdalhadi9.loyalty_management_system.service;

import com.abdalhadi9.loyalty_management_system.entity.Customer;
import com.abdalhadi9.loyalty_management_system.repository.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer registerCustomer(Customer customer){
        if (customerRepository.existsByEmail(customer.getEmail())){
            throw new RuntimeException("this email is exists");
        }
        return customerRepository.save(customer);

    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: "+id));
    }
}
