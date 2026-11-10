package com.abdalhadi9.loyalty_management_system.service;

import com.abdalhadi9.loyalty_management_system.repository.CustomerRepository;
import com.abdalhadi9.loyalty_management_system.repository.PointsTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class PointsService {
    private final CustomerRepository customerRepository;
    private final PointsTransactionRepository pointsTransactionRepository;

    public PointsService(CustomerRepository customerRepository, PointsTransactionRepository pointsTransactionRepository) {
        this.customerRepository = customerRepository;
        this.pointsTransactionRepository = pointsTransactionRepository;
    }
}
