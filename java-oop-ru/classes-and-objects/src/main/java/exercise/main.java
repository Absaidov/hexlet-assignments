package exercise;

public class main {
    public static void main(String[] args) {
        Point point = new Point(4, 3);
        Point point2 = new Point(6, 1);

        int x = point.getX(); // 4
        int y = point.getY(); // 3

//        System.out.println(x);
//        System.out.println(y);

        Segment segment = new Segment(point,point2);
        Segment segment2 = new Segment(point,point2);

        System.out.println(segment);

//        System.out.println(segment.getBeginPoint());
//        System.out.println(segment.getEndPoint());
    }
}
