package org.example.javafunctionesandtricks.examples.data.types;

public class Main {
 public static void main(String[] args) {
  int binary = 0b1010; // Binary (10 in decimal) // binary to decimal 1*2^3 + 0*2^2 + 1*2^1 + 0 * 1
  int octal = 012;     // Octal (10 in decimal) // 0*8^2 + 1 * 8^1 + 2+8^0;
  int hex = 0xA;       // Hexadecimal  // 16^0 * A(10) = 10

  System.out.println(binary);
  System.out.println(octal);
  System.out.println(hex);

  Integer a = 128;
  Integer b  =128;

  System.out.println(a==b);




 }
}
