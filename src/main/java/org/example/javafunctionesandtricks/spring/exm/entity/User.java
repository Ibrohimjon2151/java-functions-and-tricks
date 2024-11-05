package org.example.javafunctionesandtricks.spring.exm.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.example.javafunctionesandtricks.spring.exm.entity.template.AbstractEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends AbstractEntity {

 private String name;

 private String password;

}
