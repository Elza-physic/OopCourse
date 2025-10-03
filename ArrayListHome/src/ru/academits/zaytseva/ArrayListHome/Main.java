package ru.academits.zaytseva.ArrayListHome;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void deleteEvenNumbers(ArrayList<Integer> numbers) {
        numbers.removeIf(number -> number % 2 == 0);
    }

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> numbers) {
        ArrayList<Integer> newNumbersList = new ArrayList<>();

        for (Integer number : numbers) {
            if (!newNumbersList.contains(number)) {
                newNumbersList.add(number);
            }
        }

        return newNumbersList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> numbers = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {
            while (scanner.hasNext()) {
                numbers.add(scanner.nextInt());
            }
        }

        System.out.println("Исходный список: " + numbers);

        deleteEvenNumbers(numbers);
        System.out.println("Список без четных чисел: " + numbers);

        System.out.println("Список без дубликатов: " + removeDuplicates(numbers));
    }
}
