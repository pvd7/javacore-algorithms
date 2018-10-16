package ru.javacore2.algorithm.lesson5;

import java.util.Stack;

/**
 * Ханойская башня является одной из популярных головоломок XIX века.
 * Даны три стержня, на один из которых нанизаны восемь колец, причём кольца отличаются размером и лежат меньшее на большем.
 * Задача состоит в том, чтобы перенести пирамиду из восьми колец за наименьшее число ходов на другой стержень.
 * За один раз разрешается переносить только одно кольцо, причём нельзя класть большее кольцо на меньшее.
 */
public class TowerHanoi {

    private static int step;

    /**
     * Рекурсивное решение
     * Рекурсивно решаем задачу «перенести башню из n−1 диска на 2-й штырь».
     * Затем переносим самый большой диск на 3-й штырь,
     * и рекурсивно решаем задачу «перенеси башню из n−1 диска на 3-й штырь»
     *
     * @param n количство дисков
     * @param x штырь 1
     * @param y штырь 2
     * @param z штырь 3
     */
    private static void moveRecursive(int n, String x, String y, String z) {
        if (n == 1) {
            System.out.printf("%2d  диск 1 %s -> %s \n", ++step, x, y);
        } else if (n > 1) {
            moveRecursive(n - 1, x, z, y);
            System.out.printf("%2d  диск %d %s -> %s \n", ++step, n, x, y);
            moveRecursive(n - 1, z, y, x);
        }
    }

    /**
     * Циклическое решение
     * Обозначим через «1-2» такое действие: переложить диск или с 1-го штыря на 2-й, или со 2-го на 1-й,
     * в зависимости от того, где он меньше. Тогда, чтобы решить головоломку с чётным количеством дисков,
     * надо многократно повторять действия: 1-2, 1-3, 2-3. Если число дисков нечётно — 1-3, 1-2, 2-3.
     *
     * @param n количство дисков
     */
        private static void moveLoop(int n) {
        // штырь 1
        Stack<Integer> a = new Stack<>();
        // штырь 2
        Stack<Integer> b = new Stack<>();
        // штырь 3
        Stack<Integer> c = new Stack<>();

        for (int i = n; i > 0; i--) a.add(i);

        boolean evenN = ((n % 2) == 0);
        int i = 1;
        while ((n > b.size()) && (n > c.size())) {
            switch (i) {
                case 1:
                    if (evenN) move(a, b, "A", "B");
                    else move(a, c, "A", "C");
                    break;
                case 2:
                    if (evenN) move(a, c, "A", "C");
                    else move(a, b, "A", "B");
                    break;
                case 3:
                    move(b, c, "B", "C");
                    break;
            }
            i = (i < 3) ? i + 1 : 1;
        }
    }

    /**
     * Перекидываем диски между штырями, берем диск от туда где он меньше
     *
     * @param x  первый штырь
     * @param y  второй штырь
     * @param xx имя первого штыря
     * @param yy имч второго штыря
     */
    private static void move(Stack<Integer> x, Stack<Integer> y, String xx, String yy) {
        if (!y.empty() || !x.empty()) {
            int i;
            if (x.empty() || (!y.empty() && (y.peek() < x.peek()))) {
                x.add(i = y.pop());
                System.out.printf("%2d  диск %d %s -> %s (%s -> %s) \n", ++step, i, yy, xx, y, x);
            } else if (y.empty() || (!x.empty() && (x.peek() < y.peek()))) {
                y.add(i = x.pop());
                System.out.printf("%2d  диск %d %s -> %s (%s -> %s) \n", ++step, i, xx, yy, x, y);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Рекурсивное решение");
        step = 0;
        moveRecursive(n, "A", "B", "C");

        System.out.println();
        System.out.println("Циклическое решение");
        step = 0;
        moveLoop(n);
    }

}
