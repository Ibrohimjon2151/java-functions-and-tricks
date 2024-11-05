package org.example.javafunctionesandtricks.spring.exm.components;

import org.example.javafunctionesandtricks.spring.exm.repository.CardRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MonthlyScheduledTask {

 private final CardRepository cardRepository;

 public MonthlyScheduledTask(@Lazy CardRepository cardRepository) {
  this.cardRepository = cardRepository;
 }
// @Scheduled(cron = "0 0 10 * * MON") // At 10:00 AM every Monday
// @Scheduled(fixedRate = 60000) // Every minute
//@Scheduled(cron = "0 0 12 * * ?") // Every day at noon
//@Scheduled(fixedDelay = 300000, initialDelay = 10000) // 5 minutes after the previous run, with an initial delay of 10 seconds
//@Scheduled(cron = "0 0 0 1 1 ?") // At 12:00 AM on January 1st
 @Scheduled(cron = "0 23 22 2 * ?")
 public void runTask() {
  System.out.println("Task is worked");
  cardRepository.findAll().forEach(card -> {
    card.setBalance(card.getBalance() - 10000);
    cardRepository.save(card);
   }
  );
 }
}
