package com.example.daily_transactions_service.Repository;

import com.example.daily_transactions_service.Entity.DailySummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailySummaryRepository extends JpaRepository<DailySummary,Integer> {
}
