public class Dogs extends Animal {
    private static int dogCount = 0;

    public Dogs(String name) {
        super(name, 500, 10); // Вызываем конструктор суперкласса с параметрами имени, 500 м. для бега и 10 м. для плавания
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
