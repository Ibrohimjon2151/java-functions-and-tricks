package org.example.javafunctionesandtricks.repository;

import org.example.javafunctionesandtricks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByPhoneNumber(String phoneNumber);
}
