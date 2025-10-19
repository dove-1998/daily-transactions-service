package com.example.daily_transactions_service.Controller;

import com.example.daily_transactions_service.Entity.DailySummary;
import com.example.daily_transactions_service.Entity.DailyTransaction;
import com.example.daily_transactions_service.Entity.Product;
import com.example.daily_transactions_service.Service.SummaryService;
import com.example.daily_transactions_service.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController

@RequiredArgsConstructor
public class TransactionController {
    private final SummaryService summaryService;
    private final TransactionService transactionService;
    @PostMapping("/transaction/{productId}")
    public DailyTransaction addTranscation(@PathVariable("productId") Long productId, @RequestParam("Quantity") Integer Quantity){
        return transactionService.addDailyTransaction(productId, Quantity);
    }

    @PostMapping("/addTransaction")
    public Product addTranscation(@RequestBody Product product){
        return transactionService.saveData(product);
    }

    @GetMapping("/transactions")
    public List<DailyTransaction> getTransactions(){
        return transactionService.getAllTransactions();
    }

    @PostMapping("/generate/summary")
    public String generateSummary(@RequestParam("date") String date){
        summaryService.generateDailySummary(LocalDate.parse(date));
        return "Summary generated";
    }

    @GetMapping("/summaries")
    public List<DailySummary> getSummary(){
        return summaryService.getSummary();
    }
}
