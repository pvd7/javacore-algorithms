package ru.javacore2.algorithm.lesson1.example;

public class Main {

    private static void iterPrint(int i) {
        while (i >= 0) {
            System.out.print(i-- + " ");
        }
        System.out.println("e:" + i);
    }

    private static void recPrint(int i) {
        if (i >= 0) {
            System.out.print(i + " ");
            recPrint(--i);
        }
        System.out.print("r:" + i + " ");
    }

    private static int power(int base, int sign) {
        int res = 1;
        for (int i = 0; i < sign; i++) {
            res *= base;
        }
        return res;
    }

    private static int powerec(int base, int sign) {
        return (sign == 0) ? 1 : powerec(base, sign - 1) * base;
    }

    private static int routes(int x, int y) {
        if (x == 0 || y == 0)
            return 1;
        else
            return routes(x - 1, y) + routes(x, y - 1);
    }

    static int board[][] = new int[8][8];

    static void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean checkQueen(int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0)
                    if (!(i == x && j == y)) {
                        if (i - x == 0 || j - y == 0) return false;
                        if (Math.abs(i - x) == Math.abs(j - y)) return false;
                    }
            }
        }
        return true;
    }

    static boolean checkBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != 0)
                    if (!checkQueen(i, j))
                        return false;
            }
        }
        return true;
    }

    private static boolean queens(int n) {
        if (!checkBoard()) return false;
        if (n == 9) return true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = n;
                    if (queens(n + 1))
                        return true;
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //simpleSample();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%6d", routes(i, j));
            }
            System.out.println();
        }

        queens(1);
        printBoard();
    }

    private static void simpleSample() {
        iterPrint(3);
        System.out.println();
        recPrint(3);
        System.out.println();
        System.out.println(power(2, 10));
        System.out.println(powerec(2, 11));

    }
}