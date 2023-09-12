package HomeWork1;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + name);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}

class HomeWork2 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Морген Штерн", "CEO", "morgen@company.com", "+375441112233", 100000, 25),
                new Employee("Макс Корж", "HR", "rotjh@yandex.ru", "+375292223311", 80000, 34),
                new Employee("Владимир Жириновский", "AQA", "jirinovskui@company.com", "+375447776622", 60000, 65),
                new Employee("Мирон Янович", "Программист", "smirnov@company.com", "+375448887766", 50000, 30),
                new Employee("Кузнецов Кузнец Кузнецович", "Тестировщик", "kuznetsov@company.com", "+375441113344", 40000, 25)
        };

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
                System.out.println();
            }
        }
    }
}