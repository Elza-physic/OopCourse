package ru.academits.zaytseva.shapes_comparators;

import ru.academits.zaytseva.shapes.Shape;

import java.util.Comparator;

public class PerimetersComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }
}
