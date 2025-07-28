package ru.academits.zaytseva.shapes;

public class Rectangle implements Shape {
    private double rectangleLength;
    private double rectangleWidth;

    public Rectangle(double rectangleLength, double rectangleWidth) {
        this.rectangleLength = rectangleLength;
        this.rectangleWidth = rectangleWidth;
    }

    public double getRectangleLength() {
        return rectangleLength;
    }

    public double getRectangleWidth() {
        return rectangleWidth;
    }

    @Override
    public double getWidth() {
        return rectangleWidth;
    }

    @Override
    public double getHeight() {
        return rectangleLength;
    }

    @Override
    public double getArea() {
        return rectangleLength * rectangleWidth;
    }

    @Override
    public double getPerimeter() {
        return 2 * (rectangleLength + rectangleWidth);
    }

    @Override
    public String toString() {
        return "Rectangle(" + rectangleLength + ", " + rectangleWidth + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;
        return rectangleLength == rectangle.rectangleLength && rectangleWidth == rectangle.rectangleWidth;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(rectangleLength);
        hash = prime * hash + Double.hashCode(rectangleWidth);

        return hash;
    }
}
