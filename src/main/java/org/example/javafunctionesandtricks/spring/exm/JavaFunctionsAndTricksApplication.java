package org.example.javafunctionesandtricks.spring.exm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaFunctionsAndTricksApplication {
  public static void main(String[] args) {
    SpringApplication.run(JavaFunctionsAndTricksApplication.class, args);
  }
}
