package org.example.javafunctionesandtricks.spring.exm.components;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import org.example.javafunctionesandtricks.spring.exm.entity.Card;
import org.example.javafunctionesandtricks.spring.exm.entity.Transaction;
import org.example.javafunctionesandtricks.spring.exm.repository.CardRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransactionListener {


 private final CardRepository cardRepository;

 public TransactionListener(@Lazy CardRepository cardRepository) {
  this.cardRepository = cardRepository;
 }

 @PrePersist
 public void prePersist(Transaction transaction) {
  Optional<Card> optionalSource = cardRepository.findByNumber(transaction.getSourceCardNum());
  Optional<Card> optionalTarget = cardRepository.findByNumber(transaction.getTargetCardNum());

  optionalSource.ifPresent(card -> {
   card.setBalance(card.getBalance() - transaction.getAmount());
   cardRepository.save(card);
  });

  optionalTarget.ifPresent(card -> {
   card.setBalance(card.getBalance() + transaction.getAmount());
   cardRepository.save(card);
  });

 }


 @PreUpdate
 public void preUpdate(Transaction transaction) {
  System.out.println(transaction.getOldValues());
 }

 @PreRemove
 public void preRemove(Transaction transaction) {
  System.out.println(transaction);
 }

}
