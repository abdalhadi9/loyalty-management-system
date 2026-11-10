package com.abdalhadi9.loyalty_management_system.entity;

import com.abdalhadi9.loyalty_management_system.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "points_transactions")
public class PointsTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "customer is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Positive(message = "Point must be greater than zero")
    private int points;
    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Size(max = 100)
    @Column(name="description",length=100)
    private String description;
    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    protected PointsTransaction() {
    }

    public PointsTransaction(Customer customer, int points, TransactionType transactionType, String description) {
        this.customer = customer;
        this.points = points;
        this.transactionType = transactionType;
        this.description = description;
    }

    public Long getId() {
        return id;
    }


    public Customer getCustomer() {
        return customer;
    }


    public int getPoints() {
        return points;
    }


    public TransactionType getTransactionType() {
        return transactionType;
    }


    public  String getDescription() {
        return description;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}
