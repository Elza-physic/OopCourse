package ru.academits.zaytseva.shapes_main;

import ru.academits.zaytseva.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shapes[] shapes = new Shapes[6];
        shapes[0] = new Square(5.7);
        shapes[1] = new Square(4.7);
        shapes[2] = new Circle(1.5);
        shapes[3] = new Triangle(3, 1, 8.1, 4, 10.3, 1);
        shapes[4] = new Rectangle(5, 4);
        shapes[5] = new Rectangle(3, 12);

        Arrays.sort(shapes, ShapesSelection.areaComparator);
        System.out.println("Фигура с наибольшей площадью - " + shapes[shapes.length - 1].toString());

        Arrays.sort(shapes, ShapesSelection.perimeterComparator);
        System.out.println("Фигура с вторым по величине периметром - " + shapes[shapes.length - 2].toString());
    }
}
