package ru.academits.zaytseva.vector;

public class Vector {
    private int n;
    private double[] vector;

    public Vector(int n, double[] vector) {
        if (n < 0) {
            throw new IllegalArgumentException("Число n должно быть >= 0. Введено число n= " + n);
        }
        this.n = n;
        vector = new double[n];
    }


}
