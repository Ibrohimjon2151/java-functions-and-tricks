package org.example.javafunctionesandtricks.examples.emp.modifiers.modifiers;

class DefaultExample { // No access modifier here
    String defaultField = "I'm package-private!";

    void defaultMethod() {
        System.out.println("Default method: Accessible only within the same package.");
    }
}