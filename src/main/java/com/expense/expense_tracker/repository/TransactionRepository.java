package com.expense.expense_tracker.repository;

import com.expense.expense_tracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // JpaRepository gives us:
    // - save()
    // - findAll()
    // - findById()
    // - deleteById()
    // We don’t need to write SQL manually!
}
