package org.example;

public class PoorlyDesignedClass {
    public static int globalVariable = 0;

    public PoorlyDesignedClass() {
        // Empty constructor with no purpose
    }

    // Method with a poorly chosen name
    public int a() {
        return globalVariable;
    }

    // Method with unnecessary complexity
    public int b(int x, int y) {
        int result = 0;
        for (int i = 0; i < y; i++) {
            result += x;
        }
        return result;
    }

    // Unused method
    private void unusedMethod() {
        System.out.println("This method is never called.");
    }

    // Public field instead of encapsulation
    public String publicField;

    // Method with magic numbers
    public double calculateArea(double radius) {
        return 3.14 * radius * radius;
    }

    // Long method with poor readability
    public void longMethodWithPoorReadability() {
        // ... a lot of code ...
        // ... with poor indentation and inconsistent formatting ...
        boolean someCondition=false;
        if (someCondition) {
            // ... nested code ...
        }
        // ... more code ...
    }

    // Method with poor exception handling
    public void poorExceptionHandling() {
        try {
            // Code that may throw exceptions
        } catch (Exception e) {
            // Catching a broad exception type
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

