package com.firealgo.writingtest.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// we will explore different types of assertions
public class AssertionsInJunit5 {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Jane", "Doe");

    @Test
    @DisplayName("groupedAssertions using- 'assertAll()'")
    void groupedAssertions() {
        // In a grouped assertion all assertions are executed, and all
        // failures will be reported together.
        assertAll("person",
                () -> assertEquals("Jane", person.firstName()),
                () -> assertEquals("Doe", person.lastName())
        );
    }

    @Test
    void exceptionTesting() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.divide(1, 0));
        System.out.println(exception.getMessage());
        assertEquals("/ by zero", exception.getMessage());
    }
}
