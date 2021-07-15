package ru.geekbrains.lesson6.homework;

import ru.geekbrains.lesson6.homework.animals.Animal;
import ru.geekbrains.lesson6.homework.animals.Cat;
import ru.geekbrains.lesson6.homework.animals.Dog;

public class MainApp {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.run(50);
        cat1.swim(10);

        Dog dog1 = new Dog();
        dog1.run(550);
        dog1.swim(15);

        Animal cat2 = new Cat("Барсик");
        cat2.run(300);
        cat2.swim(123);
        Dog dog2 = new Dog();
        Animal dog3 = new Dog("Барбос");
        dog3.run(100);
        dog3.swim(8);

        Cat.printCounter();
        Dog.printCounter();
        Animal.printCounter();
    }
}
