package org.example.javafunctionesandtricks.util;

import lombok.RequiredArgsConstructor;
import org.example.javafunctionesandtricks.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class GenerateCardNumber {

 private final CardRepository cardRepository;

 /**
  * GENERATE RANDOM NUMBER FOR WALLER NUMBER
  */
 private String generateRandom16DigitNumber() {
  Random random = new Random();
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < 16; i++) {
   sb.append(random.nextInt(10));
  }
  return sb.toString();
 }


 /**
  * CHECK GENERATED NUMBER IS NOT EXIST IN ANOTHER Card AND RETURN
  */
 public String getUnique16DigitNumber() {
  String randomNumber;
  do {
   randomNumber = generateRandom16DigitNumber();
  } while (cardRepository.existsByCardNumber(Long.parseLong(randomNumber)));
  return randomNumber;
 }

 /**
  *  GENERATE RANDOM NUMBER FOR SMS
  */
 public int generateSixDigitNumber() {
  Random random = new Random();
  return 100000 + random.nextInt(900000);
 }
}
