package ru.geekbrains.lesson6.homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApp {

    private static final int checkOneNumber = 1;
    private static final int checkFourNumber = 4;

    public int[] newArrayAfterNumber4(int[] arr) {
        if (!Arrays.asList(arr).contains(checkFourNumber)) throw new RuntimeException();

        int pos = arr.length - 1;
        for (int i = pos; i > -1; i--) {
            if (arr[i] == checkFourNumber) {
                pos = arr[i];
                break;
            }
        }

        int size = arr.length - 1 - pos;
        int[] newArr = new int[size];
        System.arraycopy(arr, pos, newArr, 0, size);

        return newArr;
    }

    public boolean checkTheArrayContainingOnlyOneAndFour(int[] arr) {
        List list = Arrays.asList(arr);
        if (list.contains(checkOneNumber) && list.contains(checkFourNumber)) {
            for (int i = 0; i < 10; i++) {
                if ((i != checkOneNumber || i != checkFourNumber) && list.contains(i)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
