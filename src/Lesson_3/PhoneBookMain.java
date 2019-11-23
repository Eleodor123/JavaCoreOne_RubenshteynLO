package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();

        phonebook.add("Andrew", "123");
        phonebook.add("Max", "456");
        phonebook.add("Donald", "789");
        phonebook.add("Donald", "741");
        phonebook.add("George", "852");
        phonebook.add("Alex", "963");
        phonebook.get();
        phonebook.get("Donald");
    }
}
class PhoneBook {
    HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
    public void add(String name, String number) {
        List<String> phonesList = phoneBook.get(name);

        if(phonesList == null) {
            phonesList = new ArrayList<String>();
            phonesList.add(number);
            phoneBook.put(name, (ArrayList<String>) phonesList);
        } else {
            if(!phonesList.contains(number)) phonesList.add(number);
        }
    }
    public void get() {
        System.out.println(this.phoneBook);
    }
    public void get(String name) {
        System.out.println("Phone of " + name + " is " + this.phoneBook.get(name));
    }
}
