package org.example;

import java.util.Scanner;

public class Main {
     static void main() {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.print("Enter operator (+, -, *, /, ^, sqrt, %, !): ");
            String operator = scanner.next();

            try {
                double result;

                switch (operator) {
                    case "+":
                        System.out.print("Enter first number: ");
                        double add1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double add2 = scanner.nextDouble();
                        result = calc.add(add1, add2);
                        break;

                    case "-":
                        System.out.print("Enter first number: ");
                        double sub1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double sub2 = scanner.nextDouble();
                        result = calc.subtract(sub1, sub2);
                        break;

                    case "*":
                        System.out.print("Enter first number: ");
                        double mul1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double mul2 = scanner.nextDouble();
                        result = calc.multiply(mul1, mul2);
                        break;

                    case "/":
                        System.out.print("Enter first number: ");
                        double div1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double div2 = scanner.nextDouble();
                        result = calc.divide(div1, div2);
                        break;

                    case "^":
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exp = scanner.nextDouble();
                        result = calc.power(base, exp);
                        break;

                    case "sqrt":
                        System.out.print("Enter number: ");
                        double val = scanner.nextDouble();
                        result = calc.sqrt(val);
                        break;

                    case "%":
                        System.out.print("Enter first number: ");
                        double mod1 = scanner.nextDouble();
                        System.out.print("Enter second number: ");
                        double mod2 = scanner.nextDouble();
                        result = calc.modulus(mod1, mod2);
                        break;

                    case "!":
                        System.out.print("Enter integer: ");
                        int n = scanner.nextInt();
                        result = calc.factorial(n);
                        break;

                    default:
                        System.out.println("Invalid operator!");
                        continue;
                }

                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                keepRunning = false;
                System.out.println("Calculator exited.");
            }
        }


    }
}