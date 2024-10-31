package org.example.javafunctionesandtricks.entity.template;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AbstractEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.UUID)
 private UUID id;

private LocalDateTime creationDate;

 private LocalDateTime lastUpdatedDate;


 @PrePersist
 protected void onCreate() {
  creationDate = LocalDateTime.now();
  lastUpdatedDate =  LocalDateTime.now();
 }

 @PreUpdate
 protected void onUpdate() {
  lastUpdatedDate =  LocalDateTime.now();
 }
}
