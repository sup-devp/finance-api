package com.financetracker.finance_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository repository;

    // Get all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    // Add a new transaction
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    // Get balance summary
    @GetMapping("/summary")
    public Map<String, Double> getSummary() {
        List<Transaction> all = repository.findAll();
        double income = all.stream()
                .filter(t -> "INCOME".equals(t.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();
        double expenses = all.stream()
                .filter(t -> "EXPENSE".equals(t.getType()))
                .mapToDouble(Transaction::getAmount)
                .sum();
        Map<String, Double> summary = new HashMap<>();
        summary.put("totalIncome", income);
        summary.put("totalExpenses", expenses);
        summary.put("balance", income - expenses);
        return summary;
    }
}