package utils;

public class OverlappingRectangles {

    public static void main(String[] args) {

        Point p1 = new Point(1, 1);
        Point q1 = new Point(2, 2);
        Point p2 = new Point(2, 2);
        Point q2 = new Point(6, 6);

        Rectangle rectangle1 = new Rectangle(p1, q1);
        Rectangle rectangle2 = new Rectangle(p2, q2);
        System.out.println(RectangleUtils.getInterSectionArea(rectangle1, rectangle2));
    }
}

class Rectangle {

    Point tl;
    Point tr;
    Point bl;
    Point br;

    Rectangle(Point bl, Point tr) {
        this.bl = bl;
        this.tr = tr;
        tl = new Point(bl.x, tr.y);
        br = new Point(tr.x, bl.y);
    }

    int getArea() {
        return Math.abs(br.x - bl.x) * Math.abs(tl.y - bl.y);
    }
}

class RectangleUtils {

    private static boolean intersecting(Rectangle rectangle, Rectangle rectangle2) {
        return !checkForRightAndLeft(rectangle, rectangle2) && !checkForTopAndBottom(rectangle, rectangle2);
    }

    private static boolean checkForRightAndLeft(Rectangle rectangle, Rectangle rectangle2) {
        return (rectangle.bl.x < rectangle2.bl.x && rectangle.br.x < rectangle2.bl.x)
                || (rectangle.bl.x > rectangle2.br.x && rectangle.br.x > rectangle2.br.x);
    }

    private static boolean checkForTopAndBottom(Rectangle rectangle, Rectangle rectangle2) {
        return ((rectangle.tl.y < rectangle2.bl.y && rectangle.bl.y < rectangle2.bl.y)
                || (rectangle.tl.y > rectangle2.tl.y && rectangle.bl.y > rectangle2.tl.y));
    }

    static int getInterSectionArea(Rectangle rectangle1, Rectangle rectangle2) {

        if (!intersecting(rectangle1, rectangle2)) {
            return 0;
        }
        int x1 = Math.max(rectangle1.bl.x, rectangle2.bl.x);
        int y1 = Math.max(rectangle1.bl.y, rectangle2.bl.y);
        int x2 = Math.min(rectangle1.tr.x, rectangle2.tr.x);
        int y2 = Math.min(rectangle1.tr.y, rectangle2.tr.y);

        Rectangle interSectionRectangle = new Rectangle(new Point(x1, y1), new Point(x2, y2));
        return interSectionRectangle.getArea();
    }
}

class Point implements Comparable<Point> {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(this.x, this.y);
    }
}