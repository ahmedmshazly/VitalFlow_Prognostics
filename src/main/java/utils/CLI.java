package main.java.utils;

import java.io.IOException;

public class CLI {
    public static void clearScreen() {
        try {
            String os = System.getProperty("os.name");
    
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds *1000);
        } catch (InterruptedException x) {
            System.out.println(x);
        }
    }
}