package ru.academits.zaytseva.list_main;

import ru.academits.zaytseva.list.ListItem;
import ru.academits.zaytseva.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        ListItem<Integer> headItem=new ListItem<>(0);
        SinglyLinkedList<Integer> numbers = new SinglyLinkedList<>(headItem, 5);
        for (int i = 1; i < numbers.getCount(); ++i) {
            numbers.itemInsert(i, i);
        }



        System.out.println(numbers);
        //System.out.println(numbers.copyList());

        numbers.getChangedItemValue(1, 3);
        System.out.println(numbers);

        numbers.getDeletionResult(3);
        System.out.println(numbers);

    }
}
