package exercise;

import java.util.Map;

// BEGIN
class Circle {
    private Point point;
    private final int radius;

    Circle (Point point, int radius){
        this.point = point;
        this.radius = radius;
    }
    public int getRadius(){
        return radius;
    }
    public double getSquare() throws NegativeRadiusException{
        double a = Math.PI * (radius * radius);
        if (radius < 0){
            throw new NegativeRadiusException("Radius should be mo then zero");
        } else {
            return a;
        }
    }


}
// END
