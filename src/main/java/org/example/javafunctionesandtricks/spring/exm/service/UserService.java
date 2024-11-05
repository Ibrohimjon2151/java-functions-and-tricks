package org.example.javafunctionesandtricks.spring.exm.service;

import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.spring.exm.dto.UserDTO;
import org.example.javafunctionesandtricks.spring.exm.entity.User;
import org.example.javafunctionesandtricks.spring.exm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


 private final UserRepository userRepository;

 public List<User> getAllUsers() {
  return userRepository.findAll();
 }

 public User getUser(Long id) {
  return userRepository.findById(id).orElse(null);
 }

 public User createUser(UserDTO userDTO) {
  User user = new User();
  user.setName(userDTO.getName());
  user.setPassword(userDTO.getPassword());
  return userRepository.save(user);
 }

 public User updateUser(Long id, UserDTO userDTO) {
  User user = userRepository.findById(id).orElse(null);
  if (user != null) {
   user.setName(userDTO.getName());
   user.setPassword(userDTO.getPassword());
   return userRepository.save(user);
  }
  return null;
 }

 public void deleteUser(Long id) {
  userRepository.deleteById(id);
 }
}
