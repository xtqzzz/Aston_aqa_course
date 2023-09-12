package HomeWork1;

import java.io.*;
import java.util.*;

class AppData {
    public static void main(String[] args) {

    }
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void saveToCSV(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(String.join(";", header));
            for (int[] row : data) {
                writer.println(Arrays.toString(row).replaceAll("[\\[\\]]", "").replace(", ", ";"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromCSV(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            header = scanner.nextLine().split(";");
            List<int[]> dataList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] values = scanner.nextLine().split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }
                dataList.add(row);
            }
            data = dataList.toArray(new int[0][]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}