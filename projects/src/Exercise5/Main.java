package Exercise5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> logins = new ArrayList<>();
        System.out.println("Введите логины через Enter. Для завершения введите пустую строку.");
        String input = sc.nextLine();
        while (!input.isEmpty()) {
            logins.add(input);
            input = sc.nextLine();
        }
        sc.close();

        logins.stream()
                .filter(login -> login.startsWith("f"))
                .forEach(System.out::println);
    }
}