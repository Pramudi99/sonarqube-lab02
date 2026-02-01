


// package com.example;

// public class Calculator {

//     public int calculate(int a, int b, String op) {

//         switch (op) {
//             case "add":
//                 return a + b;

//             case "sub":
//                 return a - b;

//             case "mul":
//                 return a * b;

//             case "div":
//                 if (b == 0) {
//                     throw new IllegalArgumentException("Division by zero");
//                 }
//                 return a / b;

//             case "mod":
//                 return a % b;

//             case "pow":
//                 return (int) Math.pow(a, b);

//             default:
//                 throw new UnsupportedOperationException("Unknown operation: " + op);
//         }
//     }
// }





package com.example;

public class Calculator {

    public int calculate(int a, int b, Operation op) {

        switch (op) {
            case ADD:
                return a + b;

            case SUB:
                return a - b;

            case MUL:
                return a * b;

            case DIV:
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                return a / b;

            case MOD:
                return a % b;

            case POW:
                return (int) Math.pow(a, b);

            default:
                throw new UnsupportedOperationException("Unknown operation");
        }
    }
}

