package ru.academits.zaytseva.shapes;

import java.util.Comparator;

public class ShapesSelection {
    public static Comparator<Shapes> areaComparator = new Comparator<>() {
        @Override
        public int compare(Shapes shapes1, Shapes shapes2) {
            return (int) (shapes1.getArea() - shapes2.getArea());
        }
    };

    public static Comparator<Shapes> perimeterComparator = new Comparator<>() {
        @Override
        public int compare(Shapes shapes1, Shapes shapes2) {
            return (int) (shapes1.getPerimeter() - shapes2.getPerimeter());
        }
    };
}
