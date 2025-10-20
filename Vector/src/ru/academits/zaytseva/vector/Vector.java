package ru.academits.zaytseva.vector;

import java.util.Arrays;

public class Vector {
    private double[] itemsArray;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должно быть положительной. Введено значение размерности = " + dimension);
        }

        this.itemsArray = new double[dimension];
    }

    public Vector(Vector vector) {
        this.itemsArray = Arrays.copyOf(vector.itemsArray, vector.itemsArray.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше 0. Введен массив с размером = " + array.length);
        }

        this.itemsArray = Arrays.copyOf(array, array.length);
    }

    public Vector(int dimension, double[] array) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Размерность вектора должно быть положительной. Введено значение размерности = " + dimension);
        }

        this.itemsArray = new double[dimension];
        System.arraycopy(array, 0, this.itemsArray, 0, array.length);
    }

    public int getSize() {
        return itemsArray.length;
    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder("{");

        for (int i = 0; i < itemsArray.length - 1; i++) {
            vector.append(itemsArray[i]).append(", ");
        }

        return vector.append(itemsArray[itemsArray.length - 1]).append("}").toString();
    }

    public Vector addAnotherVector(Vector vector) {
        int dimension = Math.max(itemsArray.length, vector.getSize());
        itemsArray = itemsArray.length >= dimension ? itemsArray : Arrays.copyOf(itemsArray, dimension);

        for (int i = 0; i < dimension; i++) {
            double vectorValue = (i < vector.getSize()) ? vector.getComponent(i) : 0;
            itemsArray[i] += vectorValue;
        }

        return this;
    }

    public Vector subtractAnotherVector(Vector vector) {
        int dimension = Math.max(itemsArray.length, vector.getSize());
        itemsArray = itemsArray.length >= dimension ? itemsArray : Arrays.copyOf(itemsArray, dimension);

        for (int i = 0; i < dimension; i++) {
            double vectorValue = (i < vector.getSize()) ? vector.getComponent(i) : 0;
            itemsArray[i] -= vectorValue;
        }

        return this;
    }

    public void multiplicationByScalar(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            itemsArray[i] *= scalar;
        }
    }

    public void revert() {
        multiplicationByScalar(-1);
    }

    public double getLength() {
        double squaresSum = 0;

        for (double component : itemsArray) {
            squaresSum += component * component;
        }

        return Math.sqrt(squaresSum);
    }

    public double getComponent(int index) {
        if (index < 0 || index > itemsArray.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + (itemsArray.length - 1) +
                    ". Введен индекс " + index);
        }

        return itemsArray[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index > itemsArray.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс должен быть в диапазоне от 0 до " + (itemsArray.length - 1) +
                    ". Введен индекс " + index);
        }

        itemsArray[index] = value;
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
        return Arrays.equals(itemsArray, vector.itemsArray);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Arrays.hashCode(itemsArray);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        return result.addAnotherVector(vector2);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector result = new Vector(vector1);

        return result.subtractAnotherVector(vector2);
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int vectorSize = Math.min(vector1.getSize(), vector2.getSize());
        double result = 0;

        for (int i = 0; i < vectorSize; i++) {
            result += vector1.getComponent(i) * vector2.getComponent(i);
        }

        return result;
    }
}
