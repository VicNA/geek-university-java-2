package ru.geekbrains.lesson5.homework;

public class Backpack {

    private Item[] items;

    public Backpack(Item[] items) {
        this.items = items;
    }

    int findBestSum(int i, int weight) {
        if (i < 0) return 0;
        if (items[i].getWeight() > weight) return findBestSum(--i, weight);
        return Math.max(findBestSum(i - 1, weight),
                findBestSum(i - 1, weight - items[i].getWeight()) + items[i].getPrice());
    }
}
