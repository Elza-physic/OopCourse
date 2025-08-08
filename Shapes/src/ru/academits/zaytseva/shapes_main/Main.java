package ru.academits.zaytseva.shapes_main;

import ru.academits.zaytseva.shapes.*;
import ru.academits.zaytseva.shapes_comparators.ShapeAreaComparator;
import ru.academits.zaytseva.shapes_comparators.ShapePerimeterComparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(5.7),
                new Square(4.7),
                new Circle(1.5),
                new Triangle(1, 1, 10, 17, 19, 1),
                new Rectangle(5, 4),
                new Rectangle(3, 12)
        };

        Arrays.sort(shapes, new ShapeAreaComparator());
        System.out.println("Фигура с наибольшей площадью - " + shapes[shapes.length - 1]);

        Arrays.sort(shapes, new ShapePerimeterComparator());
        System.out.println("Фигура с вторым по величине периметром - " + shapes[shapes.length - 2]);
    }
}
