package ru.academits.zaytseva.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительной. Передано значение размерности = " + dimension);
        }

        components = new double[dimension];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше 0. Передан массив с размером = " + array.length);
        }

        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int dimension, double[] array) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительной. Передано значение размерности = " + dimension);
        }

        if (array == null) {
            throw new NullPointerException("Переданный массив = null");
        }

        components = Arrays.copyOf(array, dimension);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        int lastIndex = components.length - 1;

        for (int i = 0; i < lastIndex; i++) {
            stringBuilder.append(components[i]).append(", ");
        }

        return stringBuilder.append(components[lastIndex]).append("}").toString();
    }

    public void add(Vector vector) {
        int maxSize = Math.max(components.length, vector.components.length);

        if (components.length >= maxSize) {
            for (int i = 0; i < vector.components.length; i++) {
                components[i] += vector.components[i];
            }
        } else {
            components = Arrays.copyOf(components, maxSize);

            for (int i = 0; i < maxSize; i++) {
                components[i] += vector.components[i];
            }
        }
    }

    public void subtract(Vector vector) {
        vector.revert();
        add(vector);
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public void revert() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double squaresSum = 0;

        for (double component : components) {
            squaresSum += component * component;
        }

        return Math.sqrt(squaresSum);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + (components.length - 1) +
                    ". Передан индекс " + index);
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + (components.length - 1) +
                    ". Передан индекс " + index);
        }

        components[index] = value;
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
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.add(vector2);

        return result;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);
        result.subtract(vector2);

        return result;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int minSize = Math.min(vector1.components.length, vector2.components.length);
        double result = 0;

        for (int i = 0; i < minSize; i++) {
            result += vector1.components[i] * vector2.components[i];
        }

        return result;
    }
}
