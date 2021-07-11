package ru.geekbrains.lesson3.homework;

import java.util.*;

public class Phonebook {
    Map<String, Set<String>> map = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        if (map.containsKey(lastName)) {
            map.get(lastName).add(phoneNumber);
        } else {
            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            map.put(lastName, phoneNumbers);
        }
    }

    public void add(String lastName, String... phoneNumber) {
        for (String s : phoneNumber) {
            add(lastName, s);
        }
    }

    public String get(String lastName) {
        StringBuilder sb = new StringBuilder();
        for (String s : map.get(lastName)) {
            sb.append(s).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key).append(": ");
            for (String value : map.get(key)) {
                sb.append(value).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }
        return sb.toString();
    }

}
