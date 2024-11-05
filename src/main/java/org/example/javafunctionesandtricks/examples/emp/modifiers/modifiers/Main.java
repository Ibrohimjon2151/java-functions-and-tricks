package org.example.javafunctionesandtricks.examples.emp.modifiers.modifiers;

public class Main {
 public static void main(String[] args) {
  PublicExample example = new PublicExample();
  System.out.println(example.publicField); // Accessible
  example.publicMethod(); // Accessible

  var protectedField = new ProtectedExample();
  System.out.println(protectedField.protectedField);
  protectedField.protectedMethod();

  DefaultExample defaultField = new DefaultExample();
  System.out.println(defaultField.defaultField);
  defaultField.defaultMethod();

  PrivateExample privateExample = new PrivateExample();
  ///System.out.println(privateExample.privateField); There is an error in this line
  privateExample.accessPrivate();



 }
}
