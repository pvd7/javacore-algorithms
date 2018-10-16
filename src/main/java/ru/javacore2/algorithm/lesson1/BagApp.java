package ru.javacore2.algorithm.lesson1;

/**
 * Пример задачи о ранце: необходимо уложить коробки в ранец вместимостью 15 кг так, чтобы стоимость уложенных коробок была максимальной
 * Задача о ранце (или задача о рюкзаке) — NP-полная задача комбинаторной оптимизации. Своё название получила от конечной цели:
 * уложить как можно большее число ценных вещей в рюкзак при условии, что вместимость рюкзака ограничена.
 */
public class BagApp {

    static int step;

    private static int capacity = 14;
    private static int[] arrWeight = {5, 10, 6, 5};
    private static int[] arrPrice = {3, 5, 4, 2};
    private static int len = arrWeight.length;

    private static int walk1(int i, int weight) {
        if (i >= len) return 0;
        // не учитываем текущий элемент
        int p1 = walk1(i + 1, weight);
        if (weight + arrWeight[i] > capacity) return 0;
        // учитываем текущий элемент
        int p2 = arrPrice[i] + walk1(i + 1, weight + arrWeight[i]);
        step++;
        return p2 >= p1 ? p2 : p1;
    }

    static int walk2(int[] weight, int[] price, int needed) {
        int dp[][] = new int[needed + 1][len + 1];
        for (int j = 1; j <= len; j++) {
            for (int w = 1; w <= needed; w++) {
                if (weight[j - 1] <= w) {
                    dp[w][j] = Math.max(dp[w][j - 1], dp[w - weight[j - 1]][j - 1] + price[j - 1]);
                } else {
                    dp[w][j] = dp[w][j - 1];
                }
            }
        }
        return dp[needed][len];
    }

    public static void main(String[] args) {
        step = 0;
        System.out.println(walk1(0, 0));
        System.out.println(step);

        System.out.println(walk2(arrWeight, arrPrice, capacity));
    }


}
