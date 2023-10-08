package aston;

import org.testng.Assert;
import org.testng.annotations.Test;


public class FactorialTest {

    @Test
    public void testFactorial() {
        int[][] testData = {
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120}
        };
        for (int[] pair : testData) {
            int input = pair[0];
            int expected = pair[1];
            int actual = aston.Factorial.factorial(input);
            Assert.assertEquals(actual, expected, "Факториал " + input + " должен быть равен " + expected);
        }
    }
}