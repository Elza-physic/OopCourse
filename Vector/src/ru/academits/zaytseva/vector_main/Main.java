package ru.academits.zaytseva.vector_main;

import ru.academits.zaytseva.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3);
        Vector vector2 = new Vector(new double[]{4.0, 7.5, 8.0});
        Vector vector3 = new Vector(3, new double[]{3.0, 6.5});
        Vector vector4 = new Vector(vector2);
        Vector vector5 = new Vector(4, new double[]{1.2, 4.0, 3.7, 8.0});

        System.out.println("Вектор vector1 = " + vector1);
        System.out.println("Вектор vector2 = " + vector2);
        System.out.println("Вектор vector3 = " + vector3);
        System.out.println("Вектор vector4 = " + vector4);
        System.out.println("Вектор vector5 = " + vector5);
        System.out.println("Размер вектора vector2 = " + vector2.getSize());
        System.out.println("Размер вектора vector3 = " + vector3.getSize());

        vector3.add(vector5);
        System.out.println("Сумма векторов vector1 + vector2 = " + vector3);

        vector2.subtract(vector5);
        System.out.println("Разница между векторами vector2 - vector5 = " + vector2);

        vector3.multiplyByScalar(5);
        System.out.println("Вектор vector3 = " + vector3);
        System.out.println("Умножение вектора vector3 на 5 = " + vector3);

        vector3.revert();
        System.out.println("Вектор vector3 после разворота = " + vector3);

        System.out.println("Вектор vector5 = " + vector5);
        System.out.println("Длина вектора vector5 = " + vector5.getLength());

        System.out.println("Компонента вектора vector5 с индексом 1 = " + vector5.getComponent(1));

        vector5.setComponent(3, 5.6);
        System.out.println("Вектор vector5 = " + vector5);

        System.out.printf("Хэш-коды векторов vector2, vector4, vector5 равны %d, %d%n", vector2.hashCode(), vector4.hashCode());

        System.out.println("Сумма векторов vector2 и vector5 = " + Vector.getSum(vector2, vector5));

        System.out.println("Разность векторов vector2 и vector5 = " + Vector.getDifference(vector2, vector5));

        System.out.println("Скалярное произведение векторов vector2 и vector5 = " + Vector.getScalarProduct(vector2, vector5));
    }
}
