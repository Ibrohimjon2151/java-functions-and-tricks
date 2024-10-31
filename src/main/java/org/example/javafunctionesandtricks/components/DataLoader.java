package org.example.javafunctionesandtricks.components;

import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.entity.Card;
import org.example.javafunctionesandtricks.entity.User;
import org.example.javafunctionesandtricks.repository.CardRepository;
import org.example.javafunctionesandtricks.repository.UserRepository;
import org.example.javafunctionesandtricks.util.GenerateCardNumber;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {


  private final UserRepository userRepository;
  private final CardRepository cardRepository;
  private final GenerateCardNumber generateCardNumber;


  @Override
  public void run(String... args) throws Exception {
    if (userRepository.count() == 0) {
      User user = userRepository.save(new User("John", "Doe", "+90987654321"));
      User user2 = userRepository.save(new User("Jon", "Snow", "+98999555115"));
      var card = new Card();
      card.setAmount(1000_000);
//      Long cardNum = Long.parseLong(generateCardNumber.getUnique16DigitNumber());
      long cardNum = 7586285257837681L;
      card.setCardNumber(cardNum);
      card.setOwner(user);
      cardRepository.save(card);

      card = new Card();
      card.setAmount(1000_000);
      // cardNum = Long.parseLong(generateCardNumber.getUnique16DigitNumber());
      cardNum = 2592949247804930L;
      card.setCardNumber(cardNum);
      card.setOwner(user2);
      cardRepository.save(card);
    }
  }
}
