package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class FruitBox<T extends Fruit> {
    private ArrayList<T> items;

    public FruitBox(T... items) {
        this.items = new ArrayList<T>(Arrays.asList(items));
    }

    public void add(T... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void remove(T... items) {
        for (T item: items) this.items.remove(item);
    }

    public ArrayList<T> getItems() {
        return new ArrayList<T>(items);
    }

    public void clear() {
        items.clear();
    }

    public float getWeight() {
        if (items.size() == 0) return 0;
        float weight = 0;
        for (T item: items) weight += item.getWeight();
        return weight;
    }

    public boolean compare(FruitBox box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(FruitBox<? super T> box) {
        box.items.addAll(this.items);
        clear();
    }
}