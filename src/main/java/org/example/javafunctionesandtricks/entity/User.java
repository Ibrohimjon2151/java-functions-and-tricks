package org.example.javafunctionesandtricks.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.javafunctionesandtricks.entity.template.AbstractEntity;

@Getter
@Setter
@Builder
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {

  @Column(nullable = false)
  private String firstName;

  private String lastName;

  @Column(nullable = false, unique = true)
  @Size(min = 7, max = 13)
  private String phoneNumber;

}
