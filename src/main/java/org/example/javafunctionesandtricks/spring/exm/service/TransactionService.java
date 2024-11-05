package org.example.javafunctionesandtricks.spring.exm.service;

import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.spring.exm.dto.TransactionDTO;
import org.example.javafunctionesandtricks.spring.exm.entity.Transaction;
import org.example.javafunctionesandtricks.spring.exm.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {


    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setSourceCardNum(transactionDTO.getSourceCardNum());
        transaction.setTargetCardNum(transactionDTO.getTargetCardNum());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTransactorId(transactionDTO.getTransactorId());
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, TransactionDTO transactionDTO) {
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction != null) {
            Transaction oldTransaction =  Transaction.builder()
             .amount(transaction.getAmount())
             .sourceCardNum(transaction.getSourceCardNum())
             .targetCardNum(transaction.getTargetCardNum())
             .build();
            transaction.setOldValues(oldTransaction);
            transaction.setSourceCardNum(transactionDTO.getSourceCardNum());
            transaction.setTargetCardNum(transactionDTO.getTargetCardNum());
            transaction.setAmount(transactionDTO.getAmount());
            transaction.setTransactorId(transactionDTO.getTransactorId());

            // Step 3: Save updated transaction
            return transactionRepository.save(transaction);
        }
        return null;
    }


    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
