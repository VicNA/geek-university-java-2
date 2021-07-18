package ru.geekbrains.lesson6.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestMainAPp {

    private MainApp mainApp;

    @BeforeEach
    public void init() {
        mainApp = new MainApp();
    }

    @ParameterizedTest
    @MethodSource("dataForNewArrayAfterNumber4")
    public void testNewArrayAfterNumber4(int[] arr) {

    }

    public Stream<Arguments> dataForNewArrayAfterNumber4() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}));
        out.add(Arguments.arguments(new int[] {1, 2, 4, 4, 2,  1, 7}));
        out.add(Arguments.arguments(new int[] {}));
        out.add(Arguments.arguments(new int[] {4}));
        out.add(Arguments.arguments(null));
    }
}
