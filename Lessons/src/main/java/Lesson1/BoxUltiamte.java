package Lesson1;

public class BoxUltiamte<T> {
    private T obj;

    public BoxUltiamte(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("Type " + obj.getClass());
        System.out.println("obj " + obj);
    }
}
