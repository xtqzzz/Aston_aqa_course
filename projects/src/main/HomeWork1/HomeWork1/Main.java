public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dogs("Бобик"),
                new Dogs("Шарик"),
                new Cat("Мурзик"),
                new Cat("Барсик"),
                new Cat("Рыжик")
        };

        Plate plate = new Plate(100);
        for (Animal animal : animals) {
            animal.run(300);
            animal.swim(5);
            if (animal instanceof Cat) {
                Cat cat = (Cat) animal;
                if (plate.decreaseFood(10)) {
                    System.out.println(cat.name + " поел из тарелки.");
                    cat.setFull(true);
                } else { // Иначе
                    System.out.println(cat.name + " не нашел еды в тарелке.");
                    cat.setFull(false);
                }
            }
        }
        System.out.println("Всего создано животных: " + Animal.getAnimalCount());
        System.out.println();
    }
}
