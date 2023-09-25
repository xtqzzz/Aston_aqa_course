package HomeWork4;

import HomeWork4.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 20, Gender.MAN)
        );

// 1.
        double averageAge = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);

        System.out.println("Средний возраст студентов мужского пола: " + averageAge);

// 2.
        ArrayList<Student> conscripts = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Список студентов, которым грозит получение повестки в этом году:");
        for (Student student : conscripts) {
            System.out.println(student);
        }

// 3.
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