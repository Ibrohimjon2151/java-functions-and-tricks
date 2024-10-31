package org.example.javafunctionesandtricks.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.entity.Transaction;
import org.example.javafunctionesandtricks.entity.User;
import org.example.javafunctionesandtricks.payload.TransactionDto;
import org.example.javafunctionesandtricks.service.TransactionService;
import org.example.javafunctionesandtricks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionService transactionService;

  private final UserService userService;

  @PostMapping
  @Transactional
  public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDto transactionDto) {

    Transaction createdTransaction = transactionService.createTransaction(transactionDto);
    return ResponseEntity.status(201).body(createdTransaction);
  }

  @GetMapping
  public ResponseEntity<List<Transaction>> getAllTransactions() {
    List<Transaction> transactions = transactionService.getAllTransactions();
    return ResponseEntity.ok(transactions);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Transaction> getTransactionById(@PathVariable UUID id) {
    Transaction transaction = transactionService.getTransactionById(id)
      .orElseThrow(() -> new RuntimeException("Transaction not found"));
    return ResponseEntity.ok(transaction);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Transaction> updateTransaction(@PathVariable UUID id, @RequestBody TransactionDto transactionDto) {
    User transactor = userService.getUserById(transactionDto.getTransactor())
      .orElseThrow(() -> new RuntimeException("User not found"));

    Transaction transaction = Transaction.builder()
      .sourceCardNum(transactionDto.getSourceCardNum())
      .targetCardNum(transactionDto.getTargetCardNum())
      .amount(transactionDto.getAmount())
      .transactor(transactor)
      .build();

    Transaction updatedTransaction = transactionService.updateTransaction(id, transaction);
    return ResponseEntity.ok(updatedTransaction);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTransaction(@PathVariable UUID id) {
    transactionService.deleteTransaction(id);
    return ResponseEntity.noContent().build();
  }
}
