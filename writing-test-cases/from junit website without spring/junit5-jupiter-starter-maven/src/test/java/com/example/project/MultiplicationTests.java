package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MultiplicationTests {
	
	@Test
	@DisplayName("5*2 = 10")
	void multiplyTwoNumbers() {
		Multiplication multi = new Multiplication();
		assertEquals(10, multi.mulitply(5, 2), "5*2 should equal 10");
	}
	
	@ParameterizedTest(name = "{0} * {1} = {2}")
	@CsvSource({
		"0,    5,   0",
		"10,    5,   50"
	})
	void multiply(int first, int second, int expectedResult) {
		Multiplication multi = new Multiplication();
		assertEquals(expectedResult, multi.mulitply(first, second));
	}

}
