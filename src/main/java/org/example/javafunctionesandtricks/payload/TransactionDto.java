package org.example.javafunctionesandtricks.payload;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.javafunctionesandtricks.constants.TransactionStatus;
import org.example.javafunctionesandtricks.entity.User;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

  private Long sourceCardNum;

  private Long targetCardNum;

  private Double amount;

  @NotNull
  private UUID transactor;

}
