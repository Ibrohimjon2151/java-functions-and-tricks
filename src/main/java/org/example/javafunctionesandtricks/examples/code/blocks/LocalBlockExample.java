package org.example.javafunctionesandtricks.examples.code.blocks;

public class LocalBlockExample {
    public static void main(String[] args) {
        {
            int x = 5;
            System.out.println("Local block value: " + x);
        }
        // x is not accessible here as it is out of the block scope
    }
}
