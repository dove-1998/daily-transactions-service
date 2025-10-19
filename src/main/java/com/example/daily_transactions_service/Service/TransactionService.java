package com.example.daily_transactions_service.Service;

import com.example.daily_transactions_service.Entity.DailyTransaction;
import com.example.daily_transactions_service.Entity.Product;
import com.example.daily_transactions_service.Repository.DailyTransactionRepository;
import com.example.daily_transactions_service.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final DailyTransactionRepository dailyTransactionRepository;
    private final ProductRepository productRepository;

    public DailyTransaction addDailyTransaction(Long productId, Integer quantity){
        Product product = productRepository.findById(Math.toIntExact(productId))
                .orElseThrow(()->new RuntimeException("product not found"));

        DailyTransaction dailyTransaction = DailyTransaction.builder()
                .product(product)
                .transactionDate(LocalDate.now())
                .Quantity(quantity)
                .amount(quantity * product.getUnitPrice())
                .build();
        return dailyTransactionRepository.save(dailyTransaction);
    }
   public Product saveData(Product product){

       return  productRepository.save(product);
   }
    public List<DailyTransaction> getAllTransactions(){
        return dailyTransactionRepository.findAll();
    }
}
