// package main.java.com.example;

// public class Calculator {

//    // EVEN WORSE: longer, more complex, duplicated logic
// public int calculate(int a, int b, String op) {

//     if (op.equals("add")) {
//         return a + b;
//     } 
//     else if (op.equals("add-again")) {
//         return a + b; // DUPLICATION
//     } 
//     else if (op.equals("sub")) {
//         return a - b;
//     } 
//     else if (op.equals("sub-again")) {
//         return a - b; // DUPLICATION
//     } 
//     else if (op.equals("mul")) {
//         return a * b;
//     } 
//     else if (op.equals("div")) {
//         if (b == 0) {
//             return 0;
//         } else {
//             return a / b;
//         }
//     } 
//     else if (op.equals("mod")) {
//         return a % b;
//     } 
//     else if (op.equals("pow")) {
//         int result = 1;
//         for (int i = 0; i < b; i++) {
//             result = result * a;
//         }
//         return result;
//     } 
//     else {
//         return 0;
//     }
// }


//     // Code Duplication (students must remove)
//     public int addNumbers(int x, int y) {
//         return x + y;
//     }

//     public int sumValues(int a, int b) {
//         return a + b;
//     }

//     // INTENTIONAL DUPLICATION 
//     public int addAgain(int a, int b) { 
//         return a + b; 
//     } 
// }



package com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {

        switch (op) {
            case "add":
                return a + b;

            case "sub":
                return a - b;

            case "mul":
                return a * b;

            case "div":
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return a / b;

            case "mod":
                return a % b;

            case "pow":
                return (int) Math.pow(a, b);

            default:
                throw new UnsupportedOperationException("Unknown operation: " + op);
        }
    }
}
