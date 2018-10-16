package ru.javacore2.algorithm.lesson5.util;

public class Math {

    /**
     * Возведение в степень
     * Временная сложность алгоритма - O(log n) логарифмическое время,
     * т.к. при каждой итерации степень уменьшается вдвое.
     *
     * @param value что возвести в степень
     * @param power степень
     * @return результат
     */
    public static double pow(double value, int power) {
        if (power == 0) return 1.0;
        if (power == 1) return value;
        if (power == 2) return value * value;
        double result = pow(value * value, power / 2);
        return (power % 2) == 0 ? result : result * value;
    }

}
