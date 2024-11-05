package org.example.javafunctionesandtricks.examples.code.blocks;

public class StaticInitializerExample {
    static int staticValue;

    // Static initializer block
    static {
        staticValue = 20;
        System.out.println("Static initializer block executed.");
    }

    public static void main(String[] args) {
        System.out.println("Static value: " + StaticInitializerExample.staticValue);
    }
}
