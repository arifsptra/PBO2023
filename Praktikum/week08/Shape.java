public class Shape {
    String color = "red";
    boolean filled = true;

    Shape() {}

    Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Circle extends Shape {
    double radius = 1.0;

    Circle() {}

    Circle(double radius) {
        this.radius = radius;
    }

    Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * 2;
    }

    public double getPerimeter() {
        return radius * radius;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Rectangle extends Shape {
    double width = 1.0;
    double length = 1.0;

    Rectangle() {}

    Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    Rectangle(double width, double length, String color, boolean filled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.filled = filled;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return width * length * 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Square extends Rectangle {
    Square() {}
    
    Square(double side) {}
    
    Square(double side, String color, boolean filled) {}
    
    public double getSide() {
        return 0;
    }

    public void setSide(double side) {}

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}