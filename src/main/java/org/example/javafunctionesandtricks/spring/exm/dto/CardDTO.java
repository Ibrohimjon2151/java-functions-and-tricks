package org.example.javafunctionesandtricks.spring.exm.dto;

import lombok.Data;

@Data
public class CardDTO {
    private Long number;
    private String name;
    private double balance;
    private Long ownerId;
}
