package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Box box1 = new Box(1);
//        Box box2 = new Box("Str");
//
//        int x = 10;
//        x = x + (Integer) box1.getObj();
//        System.out.println("X = " + x);
//        x = x + (Integer) box2.getObj();
//        System.out.println("X = " + x);
//
//        BoxUltiamte<Integer> box1 = new BoxUltiamte<Integer>(1);
//        BoxUltiamte<String> box2 = new BoxUltiamte<String>("String1");
//
//        box1.info();
//        box2.info();
//
//        int x = 10;
//        x = x + box1.getObj();
//
//        System.out.println(x);
//        Integer inums[] = {1,2,3,4,5};
//        Stats<Integer> iob = new Stats<Integer>(inums);
//        double res1 = iob.avg();
//        System.out.println(res1);
//
//        Double dnums[] = {1.0,2.0,3.0,4.0,5.0};
//        Stats<Double> dob = new Stats<Double>(dnums);
//        double res2 = dob.avg();
//
//        System.out.println(res1 + " " + res2);
//        Stats<String> sob = new Stats<String>();
//
//        if (iob.sameAvg(dob)) {
//            System.out.println("Avg equal");
//        } else {
//            System.out.println("Avg not equal");
//        }

        Integer[] intArr = new Integer[2];

        intArr[0] = 1;
        intArr[1] = 2;

        System.out.println(Arrays.deepToString(intArr));
        swap(intArr, 0, 1);
        System.out.println(Arrays.deepToString(intArr));

        ArrayList<Integer> arrList = toArrayList(intArr);

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        FruitBox<Apple> box1 = new FruitBox<>(apple1, apple2, apple3);
        FruitBox<Orange> box2 = new FruitBox<>(orange1, orange2);

        System.out.println(box1.compare(box2));

        FruitBox<Orange> box3 = new FruitBox<>();
        box2.transfer(box3);
    }

    /**
     * Задание 1
     * Написать метод, который меняет два элемента массива местами.
     * (массив может быть любого ссылочного типа).
     */
    public static void swap(Object[] arr, int index1, int index2) {
        Object tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    /**
     * Задание 2
     * Написать метод, который преобразует массив в ArrayList.
     */
    public static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
