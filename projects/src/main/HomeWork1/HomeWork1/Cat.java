package HomeWork1;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;
    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
        isFull = false;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int getCatCount() {
        return catCount;
    }
    public boolean isFull() {
        return isFull;
    }
    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }
}
