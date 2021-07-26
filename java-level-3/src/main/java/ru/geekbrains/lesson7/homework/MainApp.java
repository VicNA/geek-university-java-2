package ru.geekbrains.lesson7.homework;

import ru.geekbrains.lesson7.homework.Annotations.AfterSuite;
import ru.geekbrains.lesson7.homework.Annotations.BeforeSuite;
import ru.geekbrains.lesson7.homework.Annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {

    private static TestClass objTestClass;

    public static void main(String[] args) {
        objTestClass = new TestClass();
        start(objTestClass.getClass());

//        start(objTestClass.getClass().getName());
    }

    private static void start(String className) {
        try {
            start(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void start(Class testClass) {
        Supplier<Stream<Method>> streamSupplier = () -> Arrays.stream(testClass.getDeclaredMethods());

        if (streamSupplier.get().filter(m -> m.getAnnotation(BeforeSuite.class) != null).count() > 1 ||
                streamSupplier.get().filter(m -> m.getAnnotation(AfterSuite.class) != null).count() > 1) {
            throw new RuntimeException();
        }

        try {
            streamSupplier.get().filter(m -> m.getAnnotation(BeforeSuite.class) != null)
                    .findFirst().get().invoke(objTestClass, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        streamSupplier.get().filter(m -> m.getAnnotation(Test.class) != null)
                .sorted(Comparator.comparingInt(m -> m.getAnnotation(Test.class).value()))
                .forEach(m -> {
            try {
                m.invoke(objTestClass, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        try {
            streamSupplier.get().filter(m -> m.getAnnotation(AfterSuite.class) != null)
                    .findFirst().get().invoke(objTestClass,null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
