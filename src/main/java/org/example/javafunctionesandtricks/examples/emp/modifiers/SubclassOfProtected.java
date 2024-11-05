package org.example.javafunctionesandtricks.examples.emp.modifiers;


import org.example.javafunctionesandtricks.examples.emp.modifiers.modifiers.ProtectedExample;

// SUB CLASS OF PROTECTED CLASS TO EXTEND ITS PROTECTED FIELD
class SubclassOfProtected extends ProtectedExample {

    public void display() {
        System.out.println(protectedField); // Accessible because Subclass inherits ProtectedExample
        protectedMethod(); // Accessible in a subclass
    }


}