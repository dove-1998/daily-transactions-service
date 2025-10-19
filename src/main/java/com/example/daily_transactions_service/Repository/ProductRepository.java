package com.example.daily_transactions_service.Repository;

import com.example.daily_transactions_service.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

