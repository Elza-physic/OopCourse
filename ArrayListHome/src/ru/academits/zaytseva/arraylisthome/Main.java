package ru.academits.zaytseva.arraylisthome;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<String> getFileStrings(String fileName) throws IOException {
        ArrayList<String> stringsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                stringsList.add(line);
            }

            return stringsList;
        }
    }

    public static ArrayList<Integer> convertToNumbersList(ArrayList<String> stringsList) {
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String line : stringsList) {
            Collections.addAll(items, line.split(" "));
        }

        for (String item : items) {
            numbers.add(Integer.valueOf(item));
        }

        return numbers;
    }

    public static void deleteEvenNumbers(ArrayList<Integer> numbers) {
        int i = 0;
        while (i < numbers.size()) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }

            i++;
        }
    }

    public static <E> ArrayList<E> getListWithoutDuplicates(ArrayList<E> list) {
        ArrayList<E> listWithoutDuplicates = new ArrayList<>(list.size());

        for (E item : list) {
            if (!listWithoutDuplicates.contains(item)) {
                listWithoutDuplicates.add(item);
            }
        }

        return listWithoutDuplicates;
    }

    public static void main(String[] args) {
        try {
            String fileName = "input.txt";
            ArrayList<String> list = getFileStrings(fileName);
            System.out.println("Исходный список: " + list);

            ArrayList<Integer> numbers = convertToNumbersList(list);
            deleteEvenNumbers(numbers);
            System.out.println("Список без четных чисел: " + numbers);

            System.out.println("Список без дубликатов: " + getListWithoutDuplicates(numbers));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла. Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла" + e.getMessage());
        }
    }
}
