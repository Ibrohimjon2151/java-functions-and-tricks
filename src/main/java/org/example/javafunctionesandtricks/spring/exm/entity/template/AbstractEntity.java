package org.example.javafunctionesandtricks.spring.exm.entity.template;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AbstractEntity {
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE)
 private Long id;

 private LocalDateTime creationDate;

 private LocalDateTime lastUpdatedDate;


 @PrePersist
 protected void onCreate() {
  creationDate = LocalDateTime.now();
  lastUpdatedDate = LocalDateTime.now();
 }

 @PreUpdate
 protected void onUpdate() {
  lastUpdatedDate = LocalDateTime.now();
 }
}
