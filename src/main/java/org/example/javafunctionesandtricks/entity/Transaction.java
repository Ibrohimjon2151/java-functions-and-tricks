package org.example.javafunctionesandtricks.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.javafunctionesandtricks.components.listeners.TransactionListener;
import org.example.javafunctionesandtricks.constants.TransactionStatus;
import org.example.javafunctionesandtricks.entity.template.AbstractEntity;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Transaction extends AbstractEntity {

  private Long sourceCardNum;

  private Long targetCardNum;

  private Double amount;

  @Enumerated(EnumType.STRING)
  private TransactionStatus status;

  @ManyToOne
  @JoinColumn(nullable = false)
  private User transactor;

}
