import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println("Массив случайных чисел: " + Arrays.toString(numbers));

        EvenChecker evenChecker = (n) -> n % 2 == 0;

        int count = 0;
        for (int number : numbers) {
            if (evenChecker.isEven(number)) {
                count++;
            }
        }
        System.out.println("Количество четных чисел: " + count);
    }

    @FunctionalInterface
    interface EvenChecker {
        boolean isEven(int n);
    }
}