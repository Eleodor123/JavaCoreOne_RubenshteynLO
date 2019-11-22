package Lesson_2;

public enum Fruit {
    ORANGE("Апельсин", 3), APPLE("Яблоко", 2), BANANA("Бабнан", 4), CHERRY("Вишня", 1);

    private String rus;
    private int weight;

    Fruit(String rus, int weight) {
        this.rus = rus;
        this.weight = weight;
    }

    public String getRus() {
        return rus;
    }

    public void setRus(String rus) {
        this.rus = rus;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class MainFruit {
    public static void main(String[] args) {
        Fruit f = Fruit.APPLE;
//
//        System.out.println(f);

        //System.out.println(Fruit.APPLE);

        for (Fruit o: Fruit.values()) {
            System.out.println(o.getRus() + " " + o + " " + o.getWeight());
        }
       // System.out.println(Fruit.BANANA.ordinal());
    }
}
