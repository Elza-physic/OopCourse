package ru.academits.zaytseva.vector;

import java.util.Arrays;

public class Vector {
    private double[] items;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительной. Передано значение размерности = " + dimension);
        }

        items = new double[dimension];
    }

    public Vector(Vector vector) {
        items = Arrays.copyOf(vector.items, vector.items.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше 0. Передан массив с размером = " + array.length);
        }

        items = Arrays.copyOf(array, array.length);
    }

    public Vector(int dimension, double[] array) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительной. Передано значение размерности = " + dimension);
        }
        if (array == null) {
            throw new NullPointerException("Переданый массив = null");
        }

        items = new double[dimension];
        System.arraycopy(array, 0, items, 0, array.length);
    }

    public int getSize() {
        return items.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        int lastIndex = items.length - 1;

        for (int i = 0; i < lastIndex; i++) {
            stringBuilder.append(items[i]).append(", ");
        }

        return stringBuilder.append(items[lastIndex]).append("}").toString();
    }

    public Vector add(Vector vector) {
        int maxLength = Math.max(items.length, vector.items.length);

        if (items.length >= maxLength) {
            for (int i = 0; i < vector.items.length; i++) {
                items[i] += vector.items[i];
            }
        } else {
            items = Arrays.copyOf(items, maxLength);

            for (int i = 0; i < maxLength; i++) {
                items[i] += vector.items[i];
            }
        }

        return this;
    }

    public Vector subtract(Vector vector) {
        int maxLength = Math.max(items.length, vector.items.length);

        if (items.length >= maxLength) {
            for (int i = 0; i < vector.items.length; i++) {
                items[i] -= vector.items[i];
            }
        } else {
            items = Arrays.copyOf(items, maxLength);

            for (int i = 0; i < maxLength; i++) {
                items[i] -= vector.items[i];
            }
        }

        return this;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < items.length; i++) {
            items[i] *= scalar;
        }
    }

    public void revert() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double squaresSum = 0;

        for (double component : items) {
            squaresSum += component * component;
        }

        return Math.sqrt(squaresSum);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= items.length) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + (items.length - 1) +
                    ". Передан индекс " + index);
        }

        return items[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= items.length) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + (items.length - 1) +
                    ". Передан индекс " + index);
        }

        items[index] = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) obj;
        return Arrays.equals(items, vector.items);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Arrays.hashCode(items);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        return result.add(vector2);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        return result.subtract(vector2);
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.items.length, vector2.items.length);
        double result = 0;

        for (int i = 0; i < minLength; i++) {
            result += vector1.items[i] * vector2.items[i];
        }

        return result;
    }
}
