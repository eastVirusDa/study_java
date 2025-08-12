package javaJungSuk_7;

abstract class Shape {
    Point p;

    Shape() {
        this(new Point(0, 0));
    }

    Shape(Point p) {
        this.p = p;
    }

    abstract double calcArea();      // 도형의 면적을 계싼해서 반환하는 메서드

    Point getPosition(Point p) {
        return p;
    }

    void setPosition(Point p) {
        this.p = p;
    }
}

class Point {
    int x;
    int y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) {
        radius = r;
    }

    public double calcArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public double calcArea() {
        return width * height;
    }

    public boolean isSquare() {
        return width == height;
    }
}


public class Exercise7_22 {
    public static double sumArea(Shape[] arr) {
        double sum = 0;
        for (Shape shape : arr) {
            sum += shape.calcArea();
        }
        return sum;
    }
    public static void main(String[] args) {
        // Exercise7_23
        Shape[] arr = {new Circle(5.0), new Rectangle(3, 4), new Circle(1)};
        System.out.println("면적의 합: " + sumArea(arr));
    }
}
