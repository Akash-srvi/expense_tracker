package com.expense.expense_tracker.controller;

import com.expense.expense_tracker.model.Transaction;
import com.expense.expense_tracker.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    // Get all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    // Add new transaction
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    // Delete transaction
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // Update transaction
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction updated) {
        return repository.findById(id).map(transaction -> {
            transaction.setAmount(updated.getAmount());
            transaction.setType(updated.getType());
            transaction.setDescription(updated.getDescription());
            return repository.save(transaction);
        }).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}
