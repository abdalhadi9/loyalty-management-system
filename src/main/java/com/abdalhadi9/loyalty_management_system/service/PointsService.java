package com.abdalhadi9.loyalty_management_system.service;

import com.abdalhadi9.loyalty_management_system.entity.Customer;
import com.abdalhadi9.loyalty_management_system.entity.PointsTransaction;
import com.abdalhadi9.loyalty_management_system.enums.TransactionType;
import com.abdalhadi9.loyalty_management_system.repository.CustomerRepository;
import com.abdalhadi9.loyalty_management_system.repository.PointsTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PointsService {
    private final CustomerRepository customerRepository;
    private final PointsTransactionRepository pointsTransactionRepository;

    public PointsService(CustomerRepository customerRepository, PointsTransactionRepository pointsTransactionRepository) {
        this.customerRepository = customerRepository;
        this.pointsTransactionRepository = pointsTransactionRepository;
    }

    @Transactional
    public PointsTransaction earnPoints(Long customerId, int points, String description) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        customer.addPoints(points);

        PointsTransaction transaction = new PointsTransaction(customer, points, TransactionType.EARN, description);

        return pointsTransactionRepository.save(transaction);
    }

    @Transactional
    public PointsTransaction redeemPoints(Long customerId, int points, String description) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        customer.deductPoints(points);

        PointsTransaction transaction = new PointsTransaction(customer, points, TransactionType.REDEEM, description);

        return pointsTransactionRepository.save(transaction);
    }

    public List<PointsTransaction> getTransactionsByCustomer(Long customerId) {


        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Customer not found with id: " + customerId);
        }

        return pointsTransactionRepository.findByCustomerIdOrderByCreatedAtDesc(customerId);
    }
}
