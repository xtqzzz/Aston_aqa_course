public class Main {
    public static void main(String[] args) {
        Employee[] person = new Employee[5];
        person[0] = new Employee("Kostyukov Nikita", "QA", "mail1@yandex.ru", "375441234567", 90000, 24 );
        person[1] = new Employee("Morgen Shtern", "HR", "mail1@yandex.ru", "375441234567", 99999, 25 );
        person[2] = new Employee("Petya Petrov", "PM", "mail1@yandex.ru", "375441234567", 82000, 18 );
        person[3] = new Employee("Dmitrij Nagiev", "DevOps", "mail1@yandex.ru", "375441234567", 5630, 41 );
        person[4] = new Employee("Nikolay Baskov", "AQA", "mail1@yandex.ru", "375441234567", 120, 50 );

        for (int i = 0; i < person.length; i++){
            if (person[i].age > 40) {
                person[i].print();
            }
        }
    }
}
class Employee {
    String fullname;
    String position;
    String email;
    String phone;
    int salary;
    int age;

    public Employee(String fullname, String position, String email, String phone, int salary, int age) {
        this.fullname = fullname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void print() {
        System.out.println(this);
    }

        @Override
        public String toString() {
            return String.format("Имя: %s \tДолжность: %s \nEmail: %s \t Номер телефона: %s \n Зарплата: %d \t Возраст: %d \n",
                    fullname, position, email, phone, salary, age);
        }
}






