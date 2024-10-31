package org.example.javafunctionesandtricks.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.entity.Transaction;
import org.example.javafunctionesandtricks.payload.TransactionDto;
import org.example.javafunctionesandtricks.repository.TransactionRepository;
import org.example.javafunctionesandtricks.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {


  private final TransactionRepository transactionRepository;
  private final UserRepository userRepository;
  private final CardService cardService;


  public Transaction createTransaction(TransactionDto transaction) {

    Transaction newTransaction = new Transaction();
    newTransaction.setAmount(transaction.getAmount());
    newTransaction.setSourceCardNum(transaction.getSourceCardNum());
    newTransaction.setTargetCardNum(transaction.getTargetCardNum());
    newTransaction.setTransactor(userRepository
      .findById(transaction
        .getTransactor())
      .orElseThrow(() -> new RuntimeException("No transactor found")));

    cardService.incomeBalance(newTransaction);
    cardService.outcomeBalance(newTransaction);



    return transactionRepository.save(newTransaction);

  }

  public List<Transaction> getAllTransactions() {
    return transactionRepository.findAll();
  }

  public Optional<Transaction> getTransactionById(UUID id) {
    return transactionRepository.findById(id);
  }


  @Transactional
  public Transaction updateTransaction(UUID id, Transaction transactionDetails) {
    Transaction transaction = transactionRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Transaction not found"));
    transaction.setSourceCardNum(transactionDetails.getSourceCardNum());
    transaction.setTargetCardNum(transactionDetails.getTargetCardNum());
    transaction.setAmount(transactionDetails.getAmount());
    transaction.setStatus(transactionDetails.getStatus());
    transaction.setTransactor(transactionDetails.getTransactor());
    return transactionRepository.save(transaction);
  }

  public void deleteTransaction(UUID id) {
    transactionRepository.deleteById(id);
  }
}
