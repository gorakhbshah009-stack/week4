package workshop5;

// Parent class Shape
class Shape {
    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }
}

// Subclass Circle overrides getArea and getPerimeter
class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println("--- Circle ---");
        System.out.printf("Area: %.2f%n", c.getArea());
        System.out.printf("Perimeter: %.2f%n", c.getPerimeter());
    }
}
