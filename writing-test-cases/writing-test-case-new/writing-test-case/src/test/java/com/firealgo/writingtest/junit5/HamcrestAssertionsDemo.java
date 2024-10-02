package com.firealgo.writingtest.junit5;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.jupiter.api.Test;
// already part of spring
class HamcrestAssertionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    void assertWithHamcrestMatcher() {
        assertThat(calculator.subtract(4, 1), is(equalTo(3)));
    }

}