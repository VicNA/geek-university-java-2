package ru.geekbrains.lesson6.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    @MethodSource("dataForNewArrayAfterNumberFour")
    public void testNewArrayAfterNumberFour(int[] arr1, int[] arr2) {
        Assertions.assertNotNull(arr1);
        Assertions.assertArrayEquals(arr2, mainApp.newArrayAfterNumberFour(arr1));
    }

    @Test
    public void testThrowsRuntimeExNewArrayAfterNumberFour() {
        Assertions.assertThrows(RuntimeException.class, () -> mainApp.newArrayAfterNumberFour(new int[]{}));
        Assertions.assertThrows(RuntimeException.class, () -> mainApp.newArrayAfterNumberFour(new int[]{5, 7, 9}));
    }

    @Test
    public void testThrowsNullPointerExNewArrayAfterNumberFour() {
        Assertions.assertThrows(NullPointerException.class, () -> mainApp.newArrayAfterNumberFour(null));
    }

    public static Stream<Arguments> dataForNewArrayAfterNumberFour() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}));
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 1, 7}, new int[]{2, 1, 7}));
        out.add(Arguments.arguments(new int[]{4}, new int[]{}));

        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckTheArrayContainingOnlyOneAndFour")
    public void testCheckTheArrayContainingOnlyOneAndFour(int[] arr, boolean result) {
        Assertions.assertEquals(result, mainApp.checkTheArrayContainingOnlyOneAndFour(arr));
    }

    public static Stream<Arguments> dataForCheckTheArrayContainingOnlyOneAndFour() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}, false));

        return out.stream();
    }
}
