package HomeWork3;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, int row, int col) {
        super(message + " в ячейке [" + row + "][" + col + "]");
    }
}
