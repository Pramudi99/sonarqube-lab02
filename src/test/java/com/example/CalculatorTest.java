package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(15, calc.calculate(10, 5, Operation.ADD));
    }

    @Test
    void testSub() {
        assertEquals(5, calc.calculate(10, 5, Operation.SUB));
    }

    @Test
    void testMul() {
        assertEquals(50, calc.calculate(10, 5, Operation.MUL));
    }

    @Test
    void testDiv() {
        assertEquals(2, calc.calculate(10, 5, Operation.DIV));
    }

    @Test
    void testDivByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.calculate(10, 0, Operation.DIV));
    }

    @Test
    void testUnknownOp() {
        assertThrows(NullPointerException.class,
                () -> calc.calculate(1, 1, null));
    }
}

