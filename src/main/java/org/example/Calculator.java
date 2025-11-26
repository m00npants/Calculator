package org.example;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }


    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double sqrt(double value) {
        if (value < 0) {
            throw new ArithmeticException("Cannot take square root of negative number!");
        }
        return Math.sqrt(value);
    }

    public double modulus(double a, double b) {
        return a % b;
    }

    public double factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("Factorial not defined for negative numbers!");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
