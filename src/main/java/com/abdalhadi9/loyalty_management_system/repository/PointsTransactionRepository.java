package com.abdalhadi9.loyalty_management_system.repository;

import com.abdalhadi9.loyalty_management_system.entity.PointsTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointsTransactionRepository extends JpaRepository<PointsTransaction,Long> {
List<PointsTransaction> findByCustomerIdOrderByCreatedAtDesc(Long customerID);
}
