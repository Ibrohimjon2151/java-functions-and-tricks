package org.example.javafunctionesandtricks.spring.exm.service;

import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.spring.exm.dto.CardDTO;
import org.example.javafunctionesandtricks.spring.exm.entity.Card;
import org.example.javafunctionesandtricks.spring.exm.repository.CardRepository;
import org.example.javafunctionesandtricks.spring.exm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

 private final CardRepository cardRepository;


 private final UserRepository userRepository;

 public List<Card> getAllCards() {
  return cardRepository.findAll();
 }

 public Card getCard(Long id) {
  return cardRepository.findById(id).orElse(null);
 }

 public Card createCard(CardDTO cardDTO) {
  Card card = new Card();
  return saveCard(cardDTO, card);
 }

 private Card saveCard(CardDTO cardDTO, Card card) {
  card.setNumber(cardDTO.getNumber());
  card.setName(cardDTO.getName());
  // set expiry date
  LocalDate now = LocalDate.now();
  Period afterTen = Period.of(10, 0, 0);
  card.setExpiryDate(now.plus(afterTen));
  card.setBalance(cardDTO.getBalance());
  card.setOwner(userRepository.findById(cardDTO.getOwnerId()).orElse(null));
  return cardRepository.save(card);
 }

 public Card updateCard(Long id, CardDTO cardDTO) {
  Card card = cardRepository.findById(id).orElse(null);
  if (card != null) {
   return saveCard(cardDTO, card);
  }
  return null;
 }

 public void deleteCard(Long id) {
  cardRepository.deleteById(id);
 }
}
