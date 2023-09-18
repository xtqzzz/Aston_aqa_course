package HomeWork2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, int row, int col) {
        super(message + " в ячейке [" + row + "][" + col + "]");
    }
}
