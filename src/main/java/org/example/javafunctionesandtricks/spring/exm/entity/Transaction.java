package org.example.javafunctionesandtricks.spring.exm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Transient;
import lombok.*;
import org.example.javafunctionesandtricks.spring.exm.components.TransactionListener;
import org.example.javafunctionesandtricks.spring.exm.entity.template.AbstractEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EntityListeners(TransactionListener.class)
public class Transaction extends AbstractEntity {

 private Long sourceCardNum;

 private Long targetCardNum;

 private double amount;

 private Long transactorId;

 @Transient
 private Transaction oldValues;
}
