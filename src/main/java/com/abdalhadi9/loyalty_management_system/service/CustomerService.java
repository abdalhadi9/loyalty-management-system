package com.abdalhadi9.loyalty_management_system.service;

import com.abdalhadi9.loyalty_management_system.dto.CustomerRequest;
import com.abdalhadi9.loyalty_management_system.entity.Customer;
import com.abdalhadi9.loyalty_management_system.exception.DuplicateEmailException;
import com.abdalhadi9.loyalty_management_system.repository.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer registerCustomer(CustomerRequest request){
        if (customerRepository.existsByEmail(request.email())){
            throw new DuplicateEmailException("Email already exist");
        }
        Customer customer=new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setPhoneNumber(request.phoneNumber());
        return customerRepository.save(customer);

    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: "+id));
    }
}
