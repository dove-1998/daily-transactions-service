package com.example.daily_transactions_service.Repository;

import com.example.daily_transactions_service.Entity.DailyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DailyTransactionRepository extends JpaRepository<DailyTransaction,Integer> {
    List<DailyTransaction> findByTransactionDate(LocalDate date);
}
