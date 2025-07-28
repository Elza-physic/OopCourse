package ru.academits.zaytseva.shapes;

import java.util.Comparator;

public class AreasComparison {
    public static Comparator<Shape> areaComparator = new Comparator<>() {
        @Override
        public int compare(Shape shape1, Shape shape2) {
            return Double.compare(shape1.getArea(), shape2.getArea());
        }
    };
}
