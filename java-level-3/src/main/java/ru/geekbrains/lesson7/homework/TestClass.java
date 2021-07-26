package ru.geekbrains.lesson7.homework;

import ru.geekbrains.lesson7.homework.Annotations.AfterSuite;
import ru.geekbrains.lesson7.homework.Annotations.BeforeSuite;
import ru.geekbrains.lesson7.homework.Annotations.Test;

public class TestClass {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Запустился метод beforeSuite с аннотацией @BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Запустился метод afterSuite с аннотацией AfterSuite");
    }

    @Test
    public void test5() {
        System.out.println("Запустился метод test5 с аннотацией Test и значение 5");
    }

    @Test(value = 3)
    public void test3() {
        System.out.println("Запустился метод test3 с аннотацией Test и значение 3");
    }

    @Test(value = 8)
    public void test8() {
        System.out.println("Запустился метод test8 с аннотацией Test и значение 8");
    }

    @Test(value = 5)
    public void test55() {
        System.out.println("Запустился метод test55 с аннотацией Test и значение 5");
    }
}
