package org.aston;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void testFactorialPositive() {
        int n = 5;
        int expected = 120;
        int actual = factorial(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testFactorialZero() {
        int n = 0;
        int expected = 1;
        int actual = factorial(n);
        assertEquals(expected, actual);
    }

    private int factorial(int n) {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() {
        int n = -3;
        factorial(n);
    }
}