package ru.geekbrains.lesson7.homework;

public class MainApp {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Murzik", 8),
                new Cat("Tostosum", 21)
        };
        Plate plate = new Plate(30);

        plate.info();
        for (Cat cat: cats) {
            cat.eat(plate);
            System.out.println(cat.getName() + " поел: " + cat.isSatiety());
        }
        plate.info();

        System.out.println("\nДобавляем еды");
        plate.increaseFood(20);
        plate.info();
        for (Cat cat : cats) {
            if (!cat.isSatiety()) cat.eat(plate);
        }

        System.out.println("\nВсе коты поели?");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + cat.isSatiety());
        }
        plate.info();
    }
}
