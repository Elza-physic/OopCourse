package ru.academits.zaytseva.range_main;

import ru.academits.zaytseva.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(5.0, 24.0);

        System.out.printf("Длина диапазона = %.2f%n", range.getLength());

        double checkNumber = 9;
        System.out.printf("Число %.2f лежит в заданном диапазоне = %b%n", checkNumber, range.isInside(checkNumber));

        range.setFrom(10.5);
        range.setTo(15.8);
        System.out.printf("Число %.2f лежит в заданном диапазоне = %b%n", checkNumber, range.isInside(checkNumber));

        Range range1 = new Range(13.6, 20.0);
        Range range2 = new Range(11.0, 18.0);

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("null");
        } else {
            System.out.printf("Интервал пересечения заданных интервалов - (%.2f; %.2f)%n", intersection.getFrom(), intersection.getTo());
        }

        Range[] union = range1.getUnion(range2);
        System.out.print("Объединение заданных интервалов - [");

        for (Range r : union) {
            System.out.printf("(%.2f; %.2f)", r.getFrom(), r.getTo());
        }

        System.out.println("]");

        Range[] difference = range1.getDifference(range2);

        if (difference == null) {
            System.out.println("Интервалы совпадают");
        } else {
            System.out.print("Разность заданных интервалов - [");

            for (Range r : difference) {
                System.out.printf("(%.2f; %.2f)", r.getFrom(), r.getTo());
            }

            System.out.println("]");
        }
    }
}
