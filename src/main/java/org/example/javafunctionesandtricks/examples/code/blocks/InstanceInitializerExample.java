package org.example.javafunctionesandtricks.examples.code.blocks;

public class InstanceInitializerExample {
    int value;

    // Instance initializer block
    {
        value = 10;
        System.out.println("Instance initializer block executed.");
    }

    public InstanceInitializerExample() {
        System.out.println("Constructor executed. Value: " + value);
    }

    public static void main(String[] args) {
        new InstanceInitializerExample(); // Prints the instance initializer message first, then the constructor message
    }
}