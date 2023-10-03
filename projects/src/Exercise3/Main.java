package Exercise3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> collection = new ArrayList<>(Arrays.asList("f10", "f15", "f2", "f4", "f4"));
        System.out.println("Коллекция: " + collection);

        String[] array = new String[collection.size()];
        collection.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .toArray(i -> array);
        System.out.println("Массив: " + Arrays.toString(array));
    }
}