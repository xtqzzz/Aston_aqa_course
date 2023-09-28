import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        System.out.println("Вес первой коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками: " + appleBox2.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("Первая коробка с яблоками равна по весу коробке с апельсинами: " + appleBox1.compare(orangeBox));

        System.out.println("Первая коробка с яблоками равна по весу второй коробке с яблоками: " + appleBox1.compare(appleBox2));

        appleBox1.transferTo(appleBox2);

        System.out.println("Вес первой коробки с яблоками после пересыпания: " + appleBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками после пересыпания: " + appleBox2.getWeight());
        System.out.println("Вес коробки с апельсинами после пересыпания: " + orangeBox.getWeight());
    }
}

abstract class Fruit {
    abstract float getWeight();
}

class Apple extends Fruit {
    @Override
    float getWeight() {
        return 1.0f;
    }
}

class Orange extends Fruit {
    @Override
    float getWeight() {
        return 1.5f;
    }
}

class Box<T extends Fruit> {
    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> other) {
        return this.getWeight() == other.getWeight();
    }

    public void transferTo(Box<T> other) {
        for (T fruit : fruits) {
            other.add(fruit);
        }
        fruits.clear();
    }
}

