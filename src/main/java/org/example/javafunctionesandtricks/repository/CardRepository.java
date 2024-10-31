package org.example.javafunctionesandtricks.repository;

import org.example.javafunctionesandtricks.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

  Optional<Card> findByCardNumber(Long sourceCardNum);

  boolean existsByCardNumber(Long cardNum);
}
