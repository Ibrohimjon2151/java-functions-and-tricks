package org.example.javafunctionesandtricks.spring.exm.repository;

import org.example.javafunctionesandtricks.spring.exm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
