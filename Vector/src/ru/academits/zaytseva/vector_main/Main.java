package ru.academits.zaytseva.vector_main;

import ru.academits.zaytseva.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector V1 = new Vector(3);
        Vector V2 = new Vector(new double[]{4.0, 7.5, 8.0});
        Vector V3 = new Vector(3, new double[]{3.0, 6.5});
        Vector V4 = new Vector(V2);
        Vector V5 = new Vector(4, new double[]{1.2, 4.0, 3.7, 8.0});

        System.out.println("Вектор V2 = " + V2);
        System.out.println("Вектор V3 = " + V3);
        System.out.println("Размер вектора V2 = " + V2.getSize());
        System.out.println("Размер вектора V3 = " + V3.getSize());

        V2.addition(V3);
        System.out.println("Сумма векторов V2 + V3 = " + V2);

        V2.difference(V3);
        System.out.println("Разница между векторами V2 - V3 = " + V2);

        V3.multiScalar(5);
        System.out.println("Вектор V3 = " + V3);
        System.out.println("Умножение вектора V4 на 5 = " + V3);

        V3.revers();
        System.out.println("Вектор V3 после разворота = " + V3);

        double length = V5.vectorLength();
        System.out.println("Вектор V5 = " + V5);
        System.out.println("Длина вектора V5 = " + length);

        double component = V5.getComponent(3);
        System.out.println("Компонента вектора V5 с индексом 3 = " + component);

        V5.setComponent(2, 5.6);
        System.out.println("Вектор V5 = " + V5);

        int hashV2 = V2.hashCode();
        int hashV4 = V4.hashCode();

        System.out.printf("Хэш-коды векторов V2, V4, V5 равны %d, %d%n", hashV2, hashV4);

        Vector sum = Vector.getAddition(V2, V5);
        System.out.println("Сумма векторов V2 + V5 = " + sum);

        double scalarProduct = Vector.getScalarProduct(V2, V5);
        System.out.println("Сумма векторов V2 + V5 = " + scalarProduct);
    }
}
