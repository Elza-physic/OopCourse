package ru.academits.zaytseva.arraylisthome;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> getFileLines(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String> linesList = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                linesList.add(line);
            }

            return linesList;
        }
    }

    public static ArrayList<Integer> convertToNumbersList(ArrayList<String> linesList) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String line : linesList) {
            String[] lineArray = line.split(" ");

            for (String number : lineArray) {
                numbers.add(Integer.valueOf(number));
            }
        }

        return numbers;
    }

    public static void deleteEvenNumbers(ArrayList<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
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
            ArrayList<String> linesList = getFileLines(fileName);
            System.out.println("Исходный список: " + linesList);

            ArrayList<Integer> numbers = convertToNumbersList(linesList);
            deleteEvenNumbers(numbers);
            System.out.println("Список без четных чисел: " + numbers);

            System.out.println("Список без дубликатов: " + getListWithoutDuplicates(numbers));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла. Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла. " + e.getMessage());
        }
    }
}
