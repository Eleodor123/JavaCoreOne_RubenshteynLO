package Lesson7;

import Lesson7.TestsPackage.TestsHandler;

public class Main {
    public static void main(String[] args) {
        ClassForTesting classForTesting = new ClassForTesting();
        TestsHandler.start(classForTesting.getClass());
    }
}