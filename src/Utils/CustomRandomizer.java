package Utils;

public class CustomRandomizer {
    /**
     * Генерация рандомного значения в заданных границах
     * @param min - граница минимум
     * @param max - граница максимум
     * @return - число в границах
     */
    public int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
