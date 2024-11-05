package org.example.javafunctionesandtricks.spring.exm.repository;

import org.example.javafunctionesandtricks.spring.exm.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
