package ru.geekbrains.lesson3.homework;

import java.util.HashMap;
import java.util.Map;

public class MainApp {

    public static void main(String[] args) {
        String[] words = {
                "aaa", "bbb", "ccc", "ddd", "eeee",
                "bbb", "abc", "ddd", "qwerty", "eeee"
        };

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.replace(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }

        System.out.println("Уникальные слова:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) System.out.println(entry.getKey());
        }

        System.out.println("\nСколько раз встречается каждое слово:");
        System.out.println(map);

        System.out.println("\nТелефонный справочник:");
        Phonebook phonebook = new Phonebook();
        phonebook.add("Smith1", "11111111");
        phonebook.add("Smith2", "22222222");
        phonebook.add("Smith3", "33333333", "44444444");
        phonebook.add("Smith2", "55555555", "55555555", "11111111");

        System.out.println("Поиск по фамилии:");
        System.out.println(phonebook.get("Smith2"));

        System.out.println("Вывести всех:");
        System.out.println(phonebook);
    }
}
