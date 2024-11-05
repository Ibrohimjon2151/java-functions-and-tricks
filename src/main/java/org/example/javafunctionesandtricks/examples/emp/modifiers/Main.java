package org.example.javafunctionesandtricks.examples.emp.modifiers;

public class Main {

 public static void main(String[] args) {

  // IT WORKS CORRECTLY WITHOUT AN ERROR BECAUSE ITS FIELDS ARE PUBLIC
//  var publicClass = new PublicExample();
//  System.out.println(publicClass.publicField);
//  publicClass.publicMethod();


  // IT WILL NOT WORK BECAUSE TRY TO ACCESS PROTECTED FIELD OUTSIDE OF PACKAGE
//  var publicClass = new ProtectedExample();
//  System.out.println(publicClass.protectedField);
//  publicClass.protectedMethod();


 }
}
