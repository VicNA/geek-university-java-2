package ru.geekbrains.lesson2.homework;

import ru.geekbrains.lesson2.homework.exception.MyArrayDataException;
import ru.geekbrains.lesson2.homework.exception.MyArraySizeException;

public class MainApp {

    public static void main(String[] args) {
        String[][] strings = {
                {"1", "2", ".3", "4"},
                {"5", "6", "7", "8"}
        };

        try {
            System.out.println("Сумма = " + sumArray(strings));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int sumArray(String[][] array) {
        if (array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }

        int sum, i, j;
        sum = i = j = 0;
        try {
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[1].length; j++) {
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]");
        }

        return sum;
    }
}
