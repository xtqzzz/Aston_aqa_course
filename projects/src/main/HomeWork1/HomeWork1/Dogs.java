package HomeWork1;

public class Dogs extends Animal {
    private static int dogCount = 0;

    public Dogs(String name) {
        super(name, 500, 10);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
