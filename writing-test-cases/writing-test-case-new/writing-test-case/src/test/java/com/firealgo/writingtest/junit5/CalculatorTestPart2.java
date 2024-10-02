package com.firealgo.writingtest.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CalculatorTestPart2 {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("1 + 1 = 2")
    @Order(2)
    void addTwoNum() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2 ");
    }

//    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    @Order(1)
    void standardAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2),
                "The optional failure message is now the last parameter");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @RepeatedTest(10)
    @DisplayName("repeatedTest add")
    void repeatedTest() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2 ");
    }
}