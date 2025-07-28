package ru.academits.zaytseva.shapes_main;

import ru.academits.zaytseva.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new Square(5.7), new Square(4.7), new Circle(1.5),
                new Triangle(3, 1, 8.1, 4, 10.3, 1), new Rectangle(5, 4),
                new Rectangle(3, 12)};

        Arrays.sort(shapes, AreasComparison.areaComparator);
        System.out.println("Фигура с наибольшей площадью - " + shapes[shapes.length - 1]);

        Arrays.sort(shapes, PerimetersComparison.perimeterComparator);
        System.out.println("Фигура с вторым по величине периметром - " + shapes[shapes.length - 2]);
    }
}
