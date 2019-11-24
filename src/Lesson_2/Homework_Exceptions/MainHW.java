package Lesson_2.Homework_Exceptions;

import java.util.Random;

public class MainHW {
    public static void main(String[] args) {
        int sum = 0;
        Random random = new Random();
        String[][] arrayOfStrings = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arrayOfStrings[i][j] = String.valueOf(random.nextInt(50));
            }
        }

        arrayOfStrings[1][3] = "asd";
        try {
            sum = sumArray(arrayOfStrings);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println(sum);

    }

    public static int sumArray(String[][] arrayOfStrings){
        int sum = 0;
        if (arrayOfStrings.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arrayOfStrings.length; i++) {
            if (arrayOfStrings[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arrayOfStrings[0].length; j++) {
                try {
                    sum += Integer.parseInt(arrayOfStrings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

class MyArrayDataException extends RuntimeException{
    int row, col;

    public MyArrayDataException(int row, int col) {
        super(row + " " + col);
        this.row = row;
        this.col = col;
    }
}

class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("wrong size");
    }
}