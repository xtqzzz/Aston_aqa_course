import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("число n не может быть отрицательным");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

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
        int actual = factorial(n); //
        assertEquals(expected, actual); //
    }

    @Test
    public void testFactorialNegative() {
        int n = -3;
        assertThrows(IllegalArgumentException.class, () -> factorial(n));
    }
}