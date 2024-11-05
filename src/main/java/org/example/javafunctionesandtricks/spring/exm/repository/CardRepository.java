package org.example.javafunctionesandtricks.spring.exm.repository;

import org.example.javafunctionesandtricks.spring.exm.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

 Optional<Card> findByNumber(Long cardNumber);

}
