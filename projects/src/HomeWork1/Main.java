package HomeWork1;

public class Main {
    public static void main(String[] args) throws MyArraySizeException {
        String[][] array = {
                {"А", "Б", "В", "Г"},
                {"Д", "Е", "Ё", "Ж"},
                {"З", "И", "Й", "К"},
                {"Л", "М", "Н", "О"}
        };
        testArray(array);

        String[][] wrongArray = {
                {"А", "Б"},
                {"В", "Г"},
                {"Д", "Е"}
        };
        testArray(wrongArray);
    }

    public static void testArray(String[][] array) throws MyArraySizeException {
        if (array != null) {
            if (array.length == 4) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i].length != 4) {
                        throw new MyArraySizeException("Массив должен быть размером 4х4");
                    }
                }
                System.out.println("Массив размером 4х4:");
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        System.out.print(array[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                throw new MyArraySizeException("Массив должен быть размером 4х4");
            }
        } else {
            throw new MyArraySizeException("Массив не может быть null");
        }
    }
}
