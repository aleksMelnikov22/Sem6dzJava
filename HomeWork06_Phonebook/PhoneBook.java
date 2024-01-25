// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.


package HomeWork06_Phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PhoneBook {
    public static void main(String[] args) {

        // HashMap телефонной книги
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Дмитрий", "9643391845");
        addContact(phoneBook, "Дмитрий", "9184587213");
        addContact(phoneBook, "Андрей", "9501486523");
        addContact(phoneBook, "Дмитрий", "583836");
        addContact(phoneBook, "Ибрагим", "9991589611");
        addContact(phoneBook, "Иван", "9851367989");

        
        System.out.println();
        printPhoneBook(phoneBook);

    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phone){
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }
    private static void printPhoneBook(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}
