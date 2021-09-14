package ru.geekbrains.lesson6.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApp {

    private static final int checkOneNumber = 1;
    private static final int checkFourNumber = 4;

    public int[] newArrayAfterNumberFour(int[] arr) {
        if (Arrays.stream(arr).noneMatch(n -> n == checkFourNumber)) throw new RuntimeException();

        int pos = arr.length - 1;
        for (int i = pos; i > -1; i--) {
            if (arr[i] == checkFourNumber) {
                pos = i;
                break;
            }
        }

        int size = arr.length - 1 - pos;
        int[] newArr = new int[size];
        System.arraycopy(arr, pos + 1, newArr, 0, size);

        return newArr;
    }

    public boolean checkTheArrayContainingOnlyOneAndFour(int[] arr) {
        if (Arrays.stream(arr).allMatch(x -> x == checkOneNumber)) return false;
        if (Arrays.stream(arr).allMatch(x -> x == checkFourNumber)) return false;

        return Arrays.stream(arr).noneMatch(x -> x != checkOneNumber && x != checkFourNumber);
    }
}
