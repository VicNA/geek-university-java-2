package ru.geekbrains.lesson6.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestMainApp {

    private MainApp mainApp;

    @BeforeEach
    public void init() {
        mainApp = new MainApp();
    }

//    @CsvSource({
//            "1, 1, 2",
//            "2, 3, 5",
//            "7, 5, 12",
//            "12, 12, 24"
//    })
//    @ParametrizedTest
//    public void massTestAdd(int a, int b, int result) {
//        Assertions.assertEquals(result, mainApp.add(a, b));
//    }


}
