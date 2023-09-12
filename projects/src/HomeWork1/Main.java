package HomeWork1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};
        AppData appData = new AppData(header, data);

        appData.save("test.csv");

        appData.load("test.csv");

        System.out.println("Заголовок:");
        for (String s : appData.getHeader()) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Данные:");
        for (int[] row : appData.getData()) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < header.length; i++) {
                writer.write(header[i]);
                if (i < header.length - 1) {
                    writer.write(";");
                }
            }
            writer.newLine();
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    writer.write(String.valueOf(data[i][j]));
                    if (j < data[i].length - 1) {
                        writer.write(";");
                    }
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            header = reader.readLine().split(";");
            ArrayList<int[]> dataList = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }
                dataList.add(row);
                line = reader.readLine();
            }
            data = dataList.toArray(new int[0][]);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}