package org.example.javafunctionesandtricks.controller;

import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.entity.Card;
import org.example.javafunctionesandtricks.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

  private final CardService cardService;

  @PostMapping
  public ResponseEntity<Card> createCard(@RequestBody Card card) {
    Card createdCard = cardService.createCard(card);
    return ResponseEntity.status(201).body(createdCard);
  }

  @GetMapping
  public ResponseEntity<List<Card>> getAllCards() {
    List<Card> cards = cardService.getAllCards();
    return ResponseEntity.ok(cards);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Card> getCardById(@PathVariable UUID id) {
    Card card = cardService.getCardById(id).orElseThrow(() -> new RuntimeException("Card not found"));
    return ResponseEntity.ok(card);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Card> updateCard(@PathVariable UUID id, @RequestBody Card cardDetails) {
    Card updatedCard = cardService.updateCard(id, cardDetails);
    return ResponseEntity.ok(updatedCard);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCard(@PathVariable UUID id) {
    cardService.deleteCard(id);
    return ResponseEntity.noContent().build();
  }
}
