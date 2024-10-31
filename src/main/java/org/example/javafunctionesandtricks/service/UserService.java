package org.example.javafunctionesandtricks.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.entity.Card;
import org.example.javafunctionesandtricks.entity.Transaction;
import org.example.javafunctionesandtricks.entity.User;
import org.example.javafunctionesandtricks.repository.CardRepository;
import org.example.javafunctionesandtricks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final CardRepository cardRepository;


  public User createUser(User user) {
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(UUID id) {
    return userRepository.findById(id);
  }

  public Optional<User> getUserByPhoneNumber(String phoneNumber) {
    return userRepository.findByPhoneNumber(phoneNumber);
  }


  public User updateUser(UUID id, User userDetails) {
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    user.setFirstName(userDetails.getFirstName());
    user.setLastName(userDetails.getLastName());
    user.setPhoneNumber(userDetails.getPhoneNumber());
    return userRepository.save(user);
  }


  public void deleteUser(UUID id) {
    userRepository.deleteById(id);
  }

}
