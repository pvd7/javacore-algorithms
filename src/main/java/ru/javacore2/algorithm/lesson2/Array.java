package ru.javacore2.algorithm.lesson2;

import java.util.HashMap;
import java.util.Map;

public class Array {

    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    /**
     * Удаляет последний элемент
     *
     * @return результат, true - элемент удален, false - элемент не удален
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    /**
     * Удаляет элемент по позиции
     *
     * @param index позиция элемента
     * @return результат, true - элемент удален, false - элемент не удален
     */
    boolean delete(int index) {
        if (size == 0) return false;
        if (index >= size) return false;
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return true;
    }

    /**
     * Удаляет все элементы равные @value
     *
     * @param value элемент, который нужно удалить
     * @return результат, true - элемент удален, false - элемент не удален
     */
    boolean deleteAll(int value) {
        if (size == 0) return false;

        int found = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) found++;
            else if (found > 0) arr[i - found] = arr[i];
        }
        size -= found;
        return found > 0;
    }

    /**
     * Удаляет все элементы
     */
    void deleteAll() {
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Перестановка элементов
     *
     * @param a позиция первого элемента
     * @param b позиция второго элемента
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Сортировка пузырьком
     * Временная сложность алгоритма - O(n^2) квадратичное время
     */
    public void sortBubble() {
        boolean isSwapped = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    isSwapped = true;
                }
            }
            // если перстановки не было, то массив отсортирован
            if (!isSwapped) break;
        }
        isSorted = true;
    }

    /**
     * Сортировка выбором
     * Временная сложность алгоритма - O(n^2) квадратичное время
     */
    public void sortSelect() {
        int cMin;
        for (int flag = 0; flag < size; flag++) {
            cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
    }

    /**
     * Сортировка вставкой
     * Временная сложность алгоритма - O(n^2) квадратичное время
     */
    public void sortInsert() {
        int in;
        int temp;
        for (int out = 0; out < size; out++) {
            temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;

    }

    /**
     * Сортировка подсчётом (алгоритм со списком)
     * Временная сложность алгоритма -  O(2 n log n) линейно-логарифмическое время
     * первый цикл за n времени, второй цикл тоже за n времени (каждое уникальное значение нужно вставить стольок раз сколько оно встречается)
     * поиск в списке по ключу считаем за логарифмичесоке время - log n
     * дополнительно требуется n памяти для подсчета уникальных значений.
     */
    public void sortCounting() {
        int count;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            count = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], count + 1);
        }

        int j = 0;
        for (Integer key : hashMap.keySet()) {
            count = hashMap.get(key);
            while (count-- > 0) {
                arr[j++] = key;
            }
        }
    }

}
