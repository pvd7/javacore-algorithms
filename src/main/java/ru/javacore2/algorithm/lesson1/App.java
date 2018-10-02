package ru.javacore2.algorithm.lesson1;

public class App {

    /**
     * Возведение в степень
     * Временная сложность алгоритма - O(log n) логарифмическое время,
     * т.к. при каждой итерции степень уменьшается вдвое.
     *
     * @param value что возвести в степень
     * @param power степень
     * @return результат
     */
    public static double pow(double value, int power) {
        if (power == 0) return 1.0;
        if (power == 1) return value;
        if (power == 2) return value * value;

        if (power % 2 == 0) {
            return pow(value * value, power / 2);
        } else {
            return pow(value * value, power / 2) * value;
        }
    }

    /**
     * Поиск минимального элемента в массиве
     * Временная сложность алгоритма - O(n) линейное время,
     * перебераем все элементы т.к. массив не отсортирован
     *
     * @param arr исходный массив
     * @return минимальное значение в массиве
     */
    public static int minArr(int[] arr) {
        int len = arr.length;

        if (len == 0) return 0;
        if (len == 1) return arr[0];

        int min = arr[0];
        for (int i = 1; i < len; i++) {
            if (min > arr[i]) min = arr[i];
        }
        return min;
    }

    /**
     * Подсчет среднего арефметического значения элементов массива
     * Временная сложность алгоритма - O(n) линейное время,
     * перебераем все элементы т.к. массив не отсортирован
     *
     * @param arr исходный массив
     * @return средне арифметическое
     */
    public static double avgArr(int[] arr) {
        int len = arr.length;

        if (len == 0) return 0;
        if (len == 1) return arr[0];

        int sum = arr[0];
        for (int i = 1; i < len; i++) {
            sum += arr[i];
        }
        return 1.0 * sum / len;
    }

    public static void main(String[] args) {
    }

}
