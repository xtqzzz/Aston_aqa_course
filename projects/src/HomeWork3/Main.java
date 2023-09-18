package HomeWork3;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = sumArray(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        String[][] wrongSizeArray = {
                {"1", "2"},
                {"3", "4"},
                {"5", "6"}
        };
        try {
            int result = sumArray(wrongSizeArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "A", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = sumArray(wrongDataArray);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array != null) {
            if (array.length == 4) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i].length != 4) {
                        throw new MyArraySizeException("Массив должен быть размером 4х4");
                    }
                }
                int sum = 0;
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        try {
                            sum += Integer.parseInt(array[i][j]);
                        } catch (NumberFormatException e) {
                            throw new MyArrayDataException("Неверные данные", i, j);
                        }
                    }
                }
                return sum;
            } else {
                throw new MyArraySizeException("Массив должен быть размером 4х4");
            }
        } else {
            throw new MyArraySizeException("Массив не может быть null");
        }
    }
}