package com.example.daily_transactions_service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailySummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate summaryDate;
    private Integer totalTransaction;
    private Integer totalQuantity;
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;

}
