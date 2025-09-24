package ru.academits.zaytseva.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Число n должно быть > 0. Введено число n= " + n);
        }
        this.vector = new double[n];
    }

    public Vector(Vector otherVector) {
        this.vector = Arrays.copyOf(otherVector.vector, otherVector.vector.length);
    }

    public Vector(double[] array) {
        this.vector = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Число n должно быть > 0. Введено число n= " + n);
        }
        this.vector = new double[n];

        for (int i = 0; i < n; i++) {
            if (i < array.length) {
                this.vector[i] = array[i];
            } else {
                this.vector[i] = 0;
            }
        }
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public int getSize() {
        return vector.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector).replace("[", "{").replace("]", "}");
    }

    public void addition(Vector secondVector) {
        int n = vector.length;

        if (n != secondVector.getSize()) {
            throw new IllegalArgumentException("Размерность векторов должна быть одинаковая. " +
                    "Размер первого вектора = " + n + ". " +
                    "Размер второго вектора = " + secondVector.getSize());
        }

        for (int i = 0; i < n; i++) {
            vector[i] += secondVector.vector[i];
        }
    }

    public void difference(Vector secondVector) {
        int n = vector.length;

        if (n != secondVector.getSize()) {
            throw new IllegalArgumentException("Размерность векторов должна быть одинаковая. " +
                    "Размер первого вектора = " + n + ". Размер второго вектора = " + secondVector.getSize());
        }

        for (int i = 0; i < n; i++) {
            vector[i] -= secondVector.vector[i];
        }
    }

    public void multiScalar(double scalar) {
        for (int i = 0; i < this.getSize(); i++) {
            this.vector[i] *= scalar;
        }
    }

    public void revers() {
        for (int i = 0; i < this.getSize(); i++) {
            this.vector[i] *= -1;
        }
    }

    public double vectorLength() {
        double squaresSum = 0;

        for (double component : vector) {
            squaresSum += component * component;
        }

        return Math.sqrt((squaresSum));
    }

    public double getComponent(int index) {
        if (index < 0 || index > vector.length) {
            throw new IllegalArgumentException("Индекс должен быть в диапазоне от 0 до " + (vector.length - 1));
        }

        return vector[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index > vector.length) {
            throw new IllegalArgumentException("Индекс должен быть в диапазоне от 0 до " + (vector.length - 1));
        }

        vector[index] = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Vector other = (Vector) obj;
        return Arrays.equals(vector, other.vector);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Arrays.hashCode(vector);
    }

    public static Vector getAddition(Vector vector1, Vector vector2) {
        int vectorSize = Math.max(vector1.getSize(), vector2.getSize());

        Vector result = new Vector(vectorSize);

        for (int i = 0; i < vectorSize; i++) {
            double value1 = (i < vector1.getSize()) ? vector1.getComponent(i) : 0;
            double value2 = (i < vector2.getSize()) ? vector2.getComponent(i) : 0;
            result.setComponent(i, value1 + value2);
        }

        return result;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        int vectorSize = Math.max(vector1.getSize(), vector2.getSize());

        Vector result = new Vector(vectorSize);

        for (int i = 0; i < vectorSize; i++) {
            double value1 = (i < vector1.getSize()) ? vector1.getComponent(i) : 0;
            double value2 = (i < vector2.getSize()) ? vector2.getComponent(i) : 0;
            result.setComponent(i, value1 - value2);
        }

        return result;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int vectorSize = Math.min(vector1.getSize(), vector2.getSize());
        double result = 0;

        for (int i = 0; i < vectorSize; i++) {
            result += vector1.getComponent(i)*vector2.getComponent(i);
        }

        return result;
    }
}
