package ru.academits.zaytseva.arraylisthome;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static ArrayList<String> getList(String fileName) {
        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Collections.addAll(list, line.split(" "));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла. Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }

        return list;
    }

    public static void deleteEvenNumbers(ArrayList<String> list) {
        Iterator<String> listIterator = list.iterator();

        while (listIterator.hasNext()) {
            String item = listIterator.next();

            if (Integer.parseInt(item) % 2 == 0) {
                listIterator.remove();
            }
        }
    }

    public static <E> ArrayList<E> getWithoutDuplicates(ArrayList<E> numbers) {
        ArrayList<E> listWithoutDuplicates = new ArrayList<>(numbers.size());

        for (E number : numbers) {
            if (!listWithoutDuplicates.contains(number)) {
                listWithoutDuplicates.add(number);
            }
        }

        return listWithoutDuplicates;
    }

    public static void main(String[] args) {
        String fileName = "input.txt";

        ArrayList<String> numbers = getList(fileName);
        System.out.println(numbers);

        deleteEvenNumbers(numbers);
        System.out.println("Список без четных чисел: " + numbers);

        System.out.println("Список без дубликатов: " + getWithoutDuplicates(numbers));
    }
}
