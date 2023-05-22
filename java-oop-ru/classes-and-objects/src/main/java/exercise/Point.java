package exercise;

// BEGIN
public class Point {
    private Integer X;
    private Integer Y;
    public Point(Integer x, Integer y) {
        X = x;
        Y = y;
    }
    public Point() {

    }
    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
// END
