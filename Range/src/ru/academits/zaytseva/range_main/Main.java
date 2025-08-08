package ru.academits.zaytseva.range_main;

import ru.academits.zaytseva.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range0 = new Range(5.0, 24.0);

        System.out.printf("Длина диапазона = %.2f%n", range0.getLength());

        double checkNumber = 9;
        System.out.printf("Число %.2f лежит в заданном диапазоне = %b%n", checkNumber, range0.isInside(checkNumber));

        range0.setFrom(10.5);
        range0.setTo(15.8);
        System.out.printf("Число %.2f лежит в заданном диапазоне = %b%n", checkNumber, range0.isInside(checkNumber));

        Range range1 = new Range(11.0, 21.0);
        Range range2 = new Range(10.0, 23.0);

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Заданные интервалы не пересекаются");
        } else {
            System.out.printf("Интервал пересечения заданных интервалов - (%.2f; %.2f)%n", intersection.getFrom(), intersection.getTo());
        }

        Range[] union = range1.getUnion(range2);
        System.out.print("Объединение заданных интервалов - [");

        for (Range range : union) {
            System.out.printf("(%.2f; %.2f)", range.getFrom(), range.getTo());
        }

        System.out.println("]");

        Range[] difference = range1.getDifference(range2);

        if (difference.length == 0) {
            System.out.println("Второй интервал больше либо равен первому интервалу");
        } else {
            System.out.print("Разность заданных интервалов - [");

            for (Range range : difference) {
                System.out.printf("(%.2f; %.2f)", range.getFrom(), range.getTo());
            }

            System.out.println("]");
        }
    }
}
