package Lesson1;

public class LambdaApp {
    public static void main(String[] args) {
        Operationable operation;
        operation = (x,y)-> y + x;

        int result = operation.calculate(10,20);
        System.out.println(result);
    }
}
interface Operationable {
    int calculate(int x, int y);
}