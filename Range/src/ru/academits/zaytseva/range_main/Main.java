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

        Range range1 = new Range(1.6, 10.0);
        Range range2 = new Range(3.6, 20.0);

        Range intersectionRange = range1.getIntersection(range2);

        if (intersectionRange == null) {
            System.out.println("null");
        } else {
            System.out.printf("Интервал пересечения заданных интервалов - (%.2f; %.2f)%n", intersectionRange.getFrom(), intersectionRange.getTo());
        }

        Range[] unionRange = range1.getRangeUnion(range2);
        System.out.print("Объединение заданных интервалов - [");

        for (Range rangeLimit : unionRange) {
            System.out.printf("(%.2f; %.2f)", rangeLimit.getFrom(), rangeLimit.getTo());
        }

        System.out.println("]");

        Range[] differenceRange = range1.getRangeDifference(range2);

        if (differenceRange == null) {
            System.out.println("Интервалы совпадают");
        } else {
            System.out.print("Разность заданных интервалов - [");

            for (Range rangeLimit : differenceRange) {
                System.out.printf("(%.2f; %.2f)", rangeLimit.getFrom(), rangeLimit.getTo());
            }

            System.out.println("]");
        }
    }
}
