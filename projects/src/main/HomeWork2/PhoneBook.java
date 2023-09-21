import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {



    private HashMap<String, ArrayList<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String phone) {
        if (phoneBook.containsKey(surname)) {
            ArrayList<String> phones = phoneBook.get(surname);
            phones.add(phone);
            phoneBook.put(surname, phones);
        } else {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(surname, phones);
        }
    }

    public void get(String surname) {
        if (phoneBook.containsKey(surname)) {
            ArrayList<String> phones = phoneBook.get(surname);
            System.out.println("По фамилии " + surname + " найдено " + phones.size() + " номер(а):");
            for (String phone : phones) {
                System.out.println(phone);
            }
        } else {
            System.out.println("По фамилии " + surname + " номер не найден.");
        }
    }

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Иванов", "+375441234567");
        pb.add("Петров", "+375446664325");
        pb.add("Сидоров", "+375441122334");
        pb.add("Иванов", "+375446667785");

        pb.get("Иванов");


        pb.get("Петров");


        pb.get("Смирнов");
    }


}
