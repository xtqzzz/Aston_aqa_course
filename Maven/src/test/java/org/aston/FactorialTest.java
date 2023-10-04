package org.aston;

import org.junit.jupiter.api.Test;

import static org.aston.Factorial.getFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    // метод для проверки факториала положительного числа
    @Test
    public void testFactorialPositive() {
        int n = 5;
        int expected = 120;
        int actual = getFactorial(n);
        assertEquals(expected, actual);
    }

    // метод для проверки факториала нуля
    @Test
    public void testFactorialZero() {
        int n = 0;
        int expected = 1;
        int actual = getFactorial(n);
        assertEquals(expected, actual);
    }

    // метод для проверки факториала отрицательного числа
    @Test
    public void testFactorialNegative() {
        int n = -3;
        assertThrows(IllegalArgumentException.class, () -> getFactorial(n)); // проверка исключения
    }
}