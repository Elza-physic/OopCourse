package ru.academits.zaytseva.arraylisthome;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> stringsList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = reader.readLine()) != null) {
            stringsList.add(line);
        }

        return stringsList;
    }

    public static ArrayList<Integer> convertToNumbersList(ArrayList<String> stringsList) {
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String string : stringsList) {
            Collections.addAll(items, string.split(" "));
        }

        for (String item : items) {
            numbers.add(Integer.valueOf(item));
        }

        return numbers;
    }

    public static void deleteEvenNumbers(ArrayList<Integer> numbers) {
        ArrayList<Integer> toRemove = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                toRemove.add(number);
            }
        }

        numbers.removeAll(toRemove);
    }

    public static <E> ArrayList<E> getListWithoutDuplicates(ArrayList<E> initialList) {
        ArrayList<E> listWithoutDuplicates = new ArrayList<>(initialList.size());

        for (E items : initialList) {
            if (!listWithoutDuplicates.contains(items)) {
                listWithoutDuplicates.add(items);
            }
        }

        return listWithoutDuplicates;
    }

    public static void main(String[] args) {
        try {
            String fileName = "input.txt";
            ArrayList<String> list = readFile(fileName);
            System.out.println("Исходный список: " + list);

            ArrayList<Integer> numbers = convertToNumbersList(list);
            deleteEvenNumbers(numbers);
            System.out.println("Список без четных чисел: " + numbers);

            System.out.println("Список без дубликатов: " + getListWithoutDuplicates(numbers));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла. Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
    }
}
