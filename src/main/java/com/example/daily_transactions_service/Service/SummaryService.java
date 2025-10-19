package com.example.daily_transactions_service.Service;

import com.example.daily_transactions_service.Entity.DailySummary;
import com.example.daily_transactions_service.Entity.DailyTransaction;
import com.example.daily_transactions_service.Entity.Product;
import com.example.daily_transactions_service.Repository.DailySummaryRepository;
import com.example.daily_transactions_service.Repository.DailyTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SummaryService {

    private final DailyTransactionRepository dailyTransactionRepository;
    private final DailySummaryRepository dailySummaryRepository;

    public List<DailySummary> getSummary(){
        return dailySummaryRepository.findAll();
    }

    public void generateDailySummary(LocalDate date){
        List<DailyTransaction> txns = dailyTransactionRepository.findByTransactionDate(date);
        Map<Product, List<DailyTransaction>> map  = txns.stream()
                .collect(Collectors.groupingBy(DailyTransaction::getProduct));
        map.forEach((product,list)->{
            int totalQty = list.stream().mapToInt(DailyTransaction::getQuantity).sum();
            Double totalAmt = list.stream().mapToDouble(DailyTransaction::getAmount).sum();

            DailySummary dailySummary = DailySummary.builder()
                    .totalQuantity(totalQty)
                    .totalAmount(totalAmt)
                    .totalTransaction(list.size())
                    .product(product)
                    .summaryDate(date)
                    .build();
            dailySummaryRepository.save(dailySummary);
        });

     }
}
