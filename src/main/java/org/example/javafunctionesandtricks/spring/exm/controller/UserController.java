package org.example.javafunctionesandtricks.spring.exm.controller;

import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.spring.exm.dto.UserDTO;
import org.example.javafunctionesandtricks.spring.exm.entity.User;
import org.example.javafunctionesandtricks.spring.exm.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

 private final UserService userService;

 @GetMapping
 public ResponseEntity<List<User>> getAllUsers() {
  return ResponseEntity.ok(userService.getAllUsers());
 }

 @GetMapping("/{id}")
 public ResponseEntity<User> getUser(@PathVariable Long id) {
  User user = userService.getUser(id);
  return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
 }

 @PostMapping
 public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
  return ResponseEntity.ok(userService.createUser(userDTO));
 }

 @PutMapping("/{id}")
 public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
  User updatedUser = userService.updateUser(id, userDTO);
  return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
  userService.deleteUser(id);
  return ResponseEntity.noContent().build();
 }
}
