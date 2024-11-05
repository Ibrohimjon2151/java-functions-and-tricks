package org.example.javafunctionesandtricks.examples.emp.modifiers.modifiers;

public class PrivateExample {
    private String privateField = "I'm private!";

    private void privateMethod() {
        System.out.println("Private method: Accessible only within this class.");
    }

    public void accessPrivate() {
        System.out.println(privateField); // Accessible within the class
        privateMethod(); // Accessible within the class
    }
}
