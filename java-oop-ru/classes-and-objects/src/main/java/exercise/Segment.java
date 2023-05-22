package exercise;

// BEGIN
public class Segment {
 private Point BeginPoint;
 private Point getEndPoint;

    public Segment(Point BeginPoint, Point getEndPoint) {
        this.BeginPoint = BeginPoint;
        this.getEndPoint = getEndPoint;
    }
    public Segment(){
    }

    public Point getBeginPoint() {
        return BeginPoint;
    }

    public Point getEndPoint() {
        return getEndPoint;
    }
    public Point getMidPoint(){
        return new Point((getBeginPoint().getX() + getEndPoint().getX()) / 2,
                (getBeginPoint().getY() + getEndPoint().getY()) / 2 );
    }


    @Override
    public String toString() {
        return "Segment{" +
                "X=" + BeginPoint.getX() +
                ", Y=" + getEndPoint.getY() +
                '}';
    }

}
// END
