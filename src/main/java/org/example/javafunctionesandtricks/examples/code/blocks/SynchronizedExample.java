package org.example.javafunctionesandtricks.examples.code.blocks;

public class SynchronizedExample {
    public void printNumbers() {
        synchronized (this) { // Synchronized block
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
        example.printNumbers(); // Calls the synchronized block
    }
}
