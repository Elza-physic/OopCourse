package ru.academits.zaytseva.list;

public class ListItem<E> {
    private E data;
    private ListItem<E> next;

    public ListItem(E data) {
        this.data = data;
    }

    public ListItem(E data, ListItem<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public ListItem<E> getNext() {
        return next;
    }

    public void setNext(ListItem<E> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        return data.equals(((ListItem<?>) o).data);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + (data != null ? data.hashCode() : 0);

        return hash;
    }
}
