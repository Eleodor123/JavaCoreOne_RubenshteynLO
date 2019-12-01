package Lesson_5;

public class MainClassHomeWork5 {
    static final int SIZE = 150000000;
    static final int HALF_SIZE = SIZE/2;

    public static void main(String[] args) {
        MainClassHomeWork5 obj = new MainClassHomeWork5();
        obj.runSingleThread();
        obj.runDoubleThread();
    }

    public float[] arrCalc (float[] arrToCalc) {
        for (int i = 0; i < arrToCalc.length; i++) {
            try {
                arrToCalc[i] = (float) (arrToCalc[i] * Math.sin(0.2f + arrToCalc[i] / 5) * Math.cos(0.2f + arrToCalc[i] / 5) * Math.cos(0.4f + arrToCalc[i] / 2));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrToCalc;
    }

    public void runSingleThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        arrCalc(arr);
        System.out.println("For Single Thread: " + (System.currentTimeMillis() - a));
    }

    public void runDoubleThread() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);

        Thread t1 = new Thread(() -> {
            float[] a1 = MainClassHomeWork5.this.arrCalc(arr1);
            System.arraycopy(a1, 0, arr1, 0, a1.length);
        });

        Thread t2 = new Thread(() -> {
            float[] a2 = MainClassHomeWork5.this.arrCalc(arr2);
            System.arraycopy(a2, 0, arr2, 0, a2.length);
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println("For Double Threads: " + (System.currentTimeMillis() - a));
    }
}
