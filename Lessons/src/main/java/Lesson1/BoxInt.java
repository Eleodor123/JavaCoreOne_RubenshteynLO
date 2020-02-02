package Lesson1;

public class BoxInt {
    private Integer obj;

    public BoxInt(Integer obj) {this.obj = obj;}

    public Integer getObj() {
        return obj;
    }

    public void setObj(Integer obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println("Type " + obj.getClass());
        System.out.println("obj " + obj);
    }
}
