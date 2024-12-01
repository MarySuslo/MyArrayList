package org.example;

import java.util.Arrays;

public class ArrayList<T> {
    /**
     * колличество элементов в коллекции
     */
    private int size;
    /**
     * начальный размер массива коллекции
     */
    private final static int CAPACITY = 16;

    /**
     * Масиив коллекции
     */
    private Object[] array;

    /**
     * Конструктор по умолчанию
     */
    public ArrayList() {
        size = 0;
        array = new Object[CAPACITY];
    }

    /**
     * Конструктор коллекци с заданным массивом
     *
     * @param array - массив коллекции
     */
    public ArrayList(T[] array) {
        size = array.length;
        this.array = array;
    }

    /**
     * Вовращает элемент коллекции по опреленному индексу
     *
     * @param index - индекс элемента
     * @return: элемент коллекции по заданному массиву
     */
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        return (T) array[index];
    }

    /**
     * Заменяет значение элемента коллекции по заданному индексу
     *
     * @param index   - индекс заменяемого элемента
     * @param element - новое начение элемента
     */
    public void set(int index, T element) {
        array[index] = element;
    }

    /**
     * вовращает количество элементов в массиве
     */
    public int size() {
        return size;
    }

    /**
     * Добавляет новый элемент в конец коллекции
     *
     * @param item - новый элемент коллекции
     */
    public void add(T item) {

        if (size == array.length)
            array = Arrays.copyOf(array, size + 1);

        this.array[size++] = item;

    }

    /**
     * Добавляет новый элемент  на опреленную позицию в коллекции.
     *
     * @param index - индекс нового элемента коллекции
     * @param item  - новый элемент коллекции
     *              Массив копируется в новый массив с бОльшим рамером. Часть массива после заданного
     *              индекса смещается на одну позицию в право.
     *              Новый элемент добавляется на "освободившееся" место по опреленному индексу
     */
    public void add(int index, T item) {
        if ((index < 0 || index >= size)&&size!=0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (size == array.length)
            array = Arrays.copyOf(array, size + 1);

        System.arraycopy(array, index, array, index + 1, size - index);

        this.array[index] = item;
        size++;
    }

    /**
     * Удаление элемента по индексу
     *
     * @param index - индекс элемента коллекции, который требуется удалить
     */
    public void remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        size--;
        if (size > index)
            System.arraycopy(array, index + 1, array, index, size - index);

        array[size] = null;

    }

    /**
     * Удаляет элемент, переданный в качестве параметра
     *
     * @param item - элемент коллекции, который требуется удалить
     */
    public void remove(T item) {
        remove(indexOf(item));
    }

    /**
     * Вовращает индекс элемента в массиве
     *
     * @param item - элемент, индекс которого необходимо найти
     * @return: вовращает индекс элемента. Если элемент не найден, вовращает -1
     */
    public int indexOf(T item) {
        for (int i = 0; i < size; i++)
            if (array[i].equals(item))
                return i;
        return -1;
    }

    /**
     * очищает полностью коллекцию
     */
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;
    }

    /**
     * Представление коллекции в виде массива
     *
     * @return: массив коллекции
     */
    public Object[] toArray() {
        Object[] items = new Object[size];
        items = array = Arrays.copyOf(array, size);
        return items;
    }

}
