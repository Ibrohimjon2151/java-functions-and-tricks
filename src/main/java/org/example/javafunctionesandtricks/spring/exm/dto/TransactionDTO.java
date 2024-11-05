
package org.example.javafunctionesandtricks.spring.exm.dto;

import lombok.Data;

@Data
public class TransactionDTO {
    private Long sourceCardNum;
    private Long targetCardNum;
    private double amount;
    private Long transactorId;
}
