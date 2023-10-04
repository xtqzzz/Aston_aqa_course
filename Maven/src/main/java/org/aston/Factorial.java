package org.aston;

public class Factorial
{
    public static void main( String[] args ) {
        System.out.println(getFactorial(0));
    }

    public static int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
