package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
        printMatrix(m, (double) n, (Object) value);
        printMatrix((double) m, n, (Object) value);
        printMatrix((double) m, (double) n, (Object) value);
        printMatrix(m, (double) n, value);
        printMatrix((double) m, n, value);
        printMatrix((double) m, (double) n, value);
    }

    public static void printMatrix(int m, double n, String value) {
        System.out.println(m+n+value);
    }

    public static void printMatrix(double m, int n, String value) {
        System.out.println(m+n+value);
    }

    public static void printMatrix(double m, double n, String value) {
        System.out.println(m+n+value);
    }

    public static void printMatrix(int m, double n, Object value) {
        System.out.print(m + n);
        System.out.println(value);
    }

    public static void printMatrix(double m, int n, Object value) {
        System.out.print(m + n);
        System.out.println(value);
    }

    public static void printMatrix(double m, double n, Object value) {
        System.out.print(m + n);
        System.out.println(value);
    }

    public static void printMatrix(float m, int n, Object value) {
        System.out.print(m + n);
        System.out.println(value);
    }

    public static void printMatrix(int m, float n, Object value) {
        System.out.print(m + n);
        System.out.println(value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
