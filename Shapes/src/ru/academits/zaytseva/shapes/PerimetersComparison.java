package ru.academits.zaytseva.shapes;

import java.util.Comparator;

public class PerimetersComparison {
    public static Comparator<Shape> perimeterComparator = new Comparator<>() {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
        }
    };
}
