package org.example.javafunctionesandtricks.components.listeners;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.transaction.Transactional;
import org.example.javafunctionesandtricks.entity.Card;
import org.example.javafunctionesandtricks.entity.Transaction;
import org.example.javafunctionesandtricks.repository.CardRepository;
import org.example.javafunctionesandtricks.service.CardService;
import org.example.javafunctionesandtricks.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;

import java.util.Optional;

@Component
public class TransactionListener {

  private final CardService cardService;

  public TransactionListener(@Lazy CardService cardService) {

    this.cardService = cardService;
  }
  @PostPersist
  @Transactional
  public void onPostPersist(Transaction transaction) {
//    cardService.incomeBalance(transaction);
//    cardService.outcomeBalance(transaction);
  }

}
