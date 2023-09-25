package HomeWork2;
import java.util.ArrayList;
import java.util.Arrays;

public class CollectionManipulation {

    public static void main(String[] args) {
        ArrayList<String> collection = new ArrayList<>(Arrays.asList("Highload", "High", "Load", "Highload"));
        System.out.println("Коллекция: " + collection);

// 1
        int count = 0;
        for (String element : collection) {
            if (element.equals("High")) {
                count++;
            }
        }
        System.out.println("Количество объектов «High» в коллекции: " + count);

// 2.
        String first = "0";
        if (!collection.isEmpty()) {
            first = collection.get(0);
        }
        System.out.println("Первый элемент в коллекции: " + first);

// 3.
        String last = "0";
        if (!collection.isEmpty()) {
            last = collection.get(collection.size() - 1);
        }
        System.out.println("Последний элемент в коллекции: " + last);
    }
}