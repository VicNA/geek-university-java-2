package ru.geekbrains.lesson7.homework;

import ru.geekbrains.lesson7.homework.Annotations.AfterSuite;
import ru.geekbrains.lesson7.homework.Annotations.BeforeSuite;
import ru.geekbrains.lesson7.homework.Annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;
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
        Method[] methods = testClass.getDeclaredMethods();

        Method beforeSuite = null;
        Method afterSuite = null;

        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (beforeSuite != null) throw new RuntimeException();
                beforeSuite = m;
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                if (afterSuite != null) throw new RuntimeException();
                afterSuite = m;
            }
        }

        if (beforeSuite != null) {
            try {
                beforeSuite.invoke(objTestClass, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        Arrays.stream(methods).filter(m -> m.getAnnotation(Test.class) != null)
                .sorted(Comparator.comparingInt(m -> m.getAnnotation(Test.class).value()))
                .forEach(m -> {
            try {
                m.invoke(objTestClass, null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        if (afterSuite != null) {
            try {
                afterSuite.invoke(objTestClass, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
