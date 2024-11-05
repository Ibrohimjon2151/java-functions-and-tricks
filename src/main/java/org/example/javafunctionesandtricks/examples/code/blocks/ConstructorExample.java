package org.example.javafunctionesandtricks.examples.code.blocks;

public class ConstructorExample {
    int number;

    public ConstructorExample(int number) {
        this.number = number;
        System.out.println("Constructor executed with number: " + this.number);
    }

    public static void main(String[] args) {
        new ConstructorExample(30); // Calls the constructor with a parameter
    }
}
