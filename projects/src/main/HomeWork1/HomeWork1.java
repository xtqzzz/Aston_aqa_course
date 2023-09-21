import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HomeWork1 {
    public static void main(String[] args) {
        String[] names = {"Никита", "Коля", "Вася", "Гена", "Петя", "Никита", "Никитос", "Барбарос", "Света", "Светлана"};
        System.out.println("Массив имён: " + Arrays.toString(names));

        HashSet<String> uniqueNames = new HashSet<>();
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        for (String word : names) {
            uniqueNames.add(word);
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        }

        System.out.println("Список уникальных имён: " + uniqueNames);
        System.out.println("Частота каждого имени: " + wordFrequency);
    }
}