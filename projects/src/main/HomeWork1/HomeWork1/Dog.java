// Класс Собака, наследующий от класса Животное
public class Dog extends Animal {
    // Статическое поле для подсчета количества собак
    private static int dogCount = 0;

    // Конструктор с параметром имени, вызывающий конструктор суперкласса с заданными ограничениями на бег и плавание
    public Dog(String name) {
        super(name, 500, 10); // Вызываем конструктор суперкласса с параметрами имени, 500 м. для бега и 10 м. для плавания
        dogCount++; // Увеличиваем счетчик собак
    }

    // Статический метод для получения количества собак
    public static int getDogCount() {
        return dogCount;
    }
}
