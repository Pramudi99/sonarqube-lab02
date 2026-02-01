// package main.java.com.example;

// public class App {

//     public static void main(String[] args) throws Exception {

//         Calculator calc = new Calculator();

//         System.out.println(calc.calculate(10, 5, "add-again"));

//         UserService service = new UserService();
//         service.findUser("admin");
//         service.deleteUser("admin"); // NEW dangerous call 
//     }
// }



package com.example;

import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();

        if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
            LOGGER.info(String.format("Result: %d", calc.calculate(10, 5, "add")));
        }

        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin");
    }
}

