package ru.academits.zaytseva.list;

import java.util.ArrayList;

public class SinglyLinkedList<E> {
    private ListItem<E> head;
    private int count;

    public SinglyLinkedList(ListItem<E> head, int count) {
        this.head = head;
        this.count = count;
    }

    public ListItem<E> getHead() {
        return head;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void itemInsert(E newItemData, int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Индекс элемента должен быть в диапазоне от 0 до " + (count - 1));
        }

        ListItem<E> item = head;
        int i = 0;

        while (i != index - 1) {
            item = item.getNext();
            ++i;
        }

        ListItem<E> newItem = new ListItem<>(newItemData);
        item.setNext((newItem));
    }

    public E getChangedItemValue(int index, E value) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Индекс элемента должен быть в диапазоне от 0 до " + (count - 1));
        }

        ListItem<E> item = head;
        int i = 0;

        while (i != index) {
            item = item.getNext();
            i++;
        }

        ListItem<E> changedItem = new ListItem<>(item.getData());
        item.setData(value);

        return changedItem.getData();
    }

    public E getDeletedItem(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Индекс элемента должен быть в диапазоне от 0 до " + (count - 1));
        }

        ListItem<E> item = head;
        int i = 0;

        while (i != index - 1) {
            item = item.getNext();
            i++;
        }

        E deletedItemValue = item.getNext().getData();
        item.setNext((item.getNext().getNext()));

        return deletedItemValue;
    }

    public void headInsert(E newHeadValue) {
        head = new ListItem<>(newHeadValue, head);
    }

    public boolean getDeletionResult(E deletedItemData) {
        boolean isDeleted = false;

        for (ListItem<E> current = head, previous = null; current.getNext() != null; previous = current, current = current.getNext()) {
            try {
                if (current.getData().equals(deletedItemData)) {
                    previous.setNext(current.getNext());
                    isDeleted = true;

                    continue;
                }
            } catch (NullPointerException e) {
                head = head.getNext();
            }
        }

        return isDeleted;
    }

    public E getDeletedHead() {
        ListItem<E> deletedHead = head.getNext();
        head = head.getNext();

        return deletedHead.getData();
    }

    public void revertList() {
        ArrayList<E> newList = new ArrayList<>();

        for (ListItem<E> item = head; item.getNext() != null; item = item.getNext()) {
            newList.addFirst(item.getData());
        }

        System.out.println(newList);
    }

    public SinglyLinkedList<E> copyList() {
        return new SinglyLinkedList<>(getHead(), getCount());
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("[");

        for (ListItem<E> item = head; item.getNext() != null; item = item.getNext()) {
            list.append(item.getData()).append("-> ");
        }

        return list.delete(list.length() - 3, list.length()).append("]").toString();
    }
}
