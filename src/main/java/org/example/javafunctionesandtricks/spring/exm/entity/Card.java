package org.example.javafunctionesandtricks.spring.exm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.javafunctionesandtricks.spring.exm.entity.template.AbstractEntity;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card extends AbstractEntity {

 private Long number;

 private String name;

 private LocalDate expiryDate;

 private double balance;

 @ManyToOne
 private User owner;



}
