package exercise;

// BEGIN
public class Cottage implements Home{
    public double area;
    public int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        double anotherArea = another.getArea();
        if (anotherArea < getArea()) {
            return 1;
        } else if (anotherArea > getArea()) {
            return -1;
        } else  {
            return 0;
        }
    }
}
// END
