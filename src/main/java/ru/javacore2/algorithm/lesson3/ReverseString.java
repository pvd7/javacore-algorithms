package ru.javacore2.algorithm.lesson3;

import java.io.*;

/**
 * Переворачивает строки из файла
 */
public class ReverseString {

    /**
     * Переворачивает строку
     *
     * @param str исходная строка
     * @return перевернутая строка
     */
    private static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] arr = str.toCharArray();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        try {
            File file = new File("files/input1.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                System.out.println(reverseString(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

