package HomeWork2;

class Main {
    public static void main(String[] args) {
        Park park = new Park("Гомельский парк");

        Park.Attraction rollerCoaster = park.new Attraction("Гомельские горки", "10:00 - 18:00", 10.0);
        Park.Attraction carousel = park.new Attraction("Карусель", "10:00 - 20:00", 8.0);
        Park.Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "12:00 - 22:00", 12.5);

        System.out.println("Парк: " + park.getName());
        System.out.println();

        rollerCoaster.printInfo();
        carousel.printInfo();
        ferrisWheel.printInfo();
    }
}

class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public class Attraction {
        private String name;
        private String time;
        private double price;

        public Attraction(String name, String time, double price) {
            this.name = name;
            this.time = time;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }

        public double getPrice() {
            return price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + time);
            System.out.println("Стоимость: " + price + " рублей");
            System.out.println();
        }
    }
}
