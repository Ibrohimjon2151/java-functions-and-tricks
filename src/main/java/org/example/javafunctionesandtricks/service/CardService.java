package org.example.javafunctionesandtricks.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.entity.Card;
import org.example.javafunctionesandtricks.entity.Transaction;
import org.example.javafunctionesandtricks.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(UUID id) {
        return cardRepository.findById(id);
    }

    public Card updateCard(UUID id, Card cardDetails) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
        card.setCardNumber(cardDetails.getCardNumber());
        card.setAmount(cardDetails.getAmount());
        card.setOwner(cardDetails.getOwner());
        return cardRepository.save(card);
    }

    public void deleteCard(UUID id) {
        cardRepository.deleteById(id);
    }



    public void outcomeBalance(Transaction transaction) {
        Card cardById = getCardById(transaction.getSourceCardNum());
        cardById.setAmount(cardById.getAmount() - transaction.getAmount());
        cardRepository.save(cardById);
    }


    public void incomeBalance(Transaction transaction) {
        Card cardById = getCardById(transaction.getSourceCardNum());
        cardById.setAmount(cardById.getAmount() + transaction.getAmount());

        cardRepository.save(cardById);
    }

    public Card getCardById(Long id) {
        return cardRepository.findByCardNumber(id).orElseThrow(() -> new RuntimeException("Card not found"));
    }
}
