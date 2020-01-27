package Lesson1;

import java.sql.SQLOutput;

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
        Integer inums[] = {1,2,3,4,5};
        Stats<Integer> iob = new Stats<Integer>(inums);
        double res1 = iob.avg();
        System.out.println(res1);

        Double dnums[] = {1.0,2.0,3.0,4.0,5.0};
        Stats<Double> dob = new Stats<Double>(dnums);
        double res2 = dob.avg();

//        System.out.println(res1 + " " + res2);
//        Stats<String> sob = new Stats<String>();

        if (iob.sameAvg(dob)) {
            System.out.println("Avg equal");
        } else {
            System.out.println("Avg not equal");
        }
}
}
