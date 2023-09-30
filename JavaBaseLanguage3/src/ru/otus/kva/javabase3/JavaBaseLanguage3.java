package ru.otus.kva.javabase3;

import java.util.Arrays;

public class JavaBaseLanguage3 {
    public static void main(String[] args) {

        int[][] arrNull = null;
        System.out.println("Результат: " + sumOfPositiveElements(arrNull));
        int[][] arr = {{1, 1, 1, 1}, {2}, {3, 3}};
        System.out.println("Результат: " + sumOfPositiveElements(arr));
        int[][] arr1 = {{-1, -3}, {0, -4}};
        System.out.println("Результат: " + sumOfPositiveElements(arr1));
        int[][] arr2 = {{-1, 3}, {0, -4}, {2}};
        System.out.println("Результат: " + sumOfPositiveElements(arr2));

        System.out.println("-----------------------------");

        printSquare(0);
        printSquare(-3);
        printSquare(5);

        System.out.println("-----------------------------");

        resetDiagonal(arrNull);
        int[][] a = {{1, 2, 3, 4}, {4, 3, 2, 1}, {1, 2, 3, 4}, {4, 3, 2, 1}};
        resetDiagonal(a);
        int[][] b = new int[5][5];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = 5;
            }
        }
        resetDiagonal(b);

        System.out.println("-----------------------------");

        System.out.println("Результат: " + findMax(arrNull));
        System.out.println("Результат: " + findMax(arr));
        System.out.println("Результат: " + findMax(arr1));
        System.out.println("Результат: " + findMax(arr2));

        System.out.println("-----------------------------");

        System.out.println("Результат: " + sumLine(0, arrNull));
        System.out.println("Результат: " + sumLine(2, arr));
        System.out.println("Результат: " + sumLine(1, arr1));
        System.out.println("Результат: " + sumLine(3, arr2));

        System.out.println("-----------------------------");

        System.out.println("Результат: " + sumColumn(0, arrNull));
        System.out.println("Результат: " + sumColumn(1, arr));
        System.out.println("Результат: " + sumColumn(3, arr));
        System.out.println("Результат: " + sumColumn(2, arr1));
        System.out.println("Результат: " + sumColumn(0, arr2));
    }

    //Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив,
    // метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
    public static int sumOfPositiveElements(int[][] arr) {
        System.out.println("\nМетод sumOfPositiveElements (" + Arrays.deepToString(arr) + ")");
        if (arr == null) {
            System.out.println("Нет ссылки на массив");
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    //Реализовать метод, который принимает в качестве аргумента int size и
    // печатает в консоль квадрат из символов * со сторонами соответствующей длины;
    public static void printSquare(int size) {
        System.out.println("\nМетод printSquare (" + size + ")");
        if (size <= 0) {
            System.out.println("Ищите Ваш квадрат в черной дыре.");
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    //Реализовать метод, принимающий в качестве аргумента квадратный двумерный целочисленный массив,
    // и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе).
    // Проверять количество строк и столбцов не требуется, условие “квадратности” нужно,
    // чтобы упростить вам работу с диагоналями;
    public static void resetDiagonal(int[][] arr) {
        System.out.println("\nМетод resetDiagonal (" + Arrays.deepToString(arr) + ")");
        if (arr == null) {
            System.out.println("Нет ссылки на массив");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ((i == j) || (i == arr[i].length - 1 - j)) {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
    public static int findMax(int[][] array) {
        System.out.println("\nМетод findMax (" + Arrays.deepToString(array) + ")");
        if (array == null) {
            System.out.println("Нет ссылки на массив");
            return Integer.MIN_VALUE;
        }
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    //Реализуйте метод, который считает сумму элементов второй строки или столбца двумерного массива (по вашему выбору),
    // если второй строки/столбца не существует, то в качестве результата необходимо вернуть -1
    public static int sumLine(int numderLine, int[][] arr) {
        System.out.println("\nМетод sumLine (" + numderLine + ", " + Arrays.deepToString(arr) + ")");
        if ((arr == null) || (arr.length - 1 < numderLine)) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < arr[numderLine].length; i++) {
            sum += arr[numderLine][i];
        }
        return sum;
    }

    public static int sumColumn(int numderColumn, int[][] arr) {
        System.out.println("\nМетод sumColumn (" + numderColumn + ", " + Arrays.deepToString(arr) + ")");
        if (arr == null) {
            return -1;
        }
        int sum = 0;
        boolean existenceFlg = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length - 1 >= numderColumn) {
                sum += arr[i][numderColumn];
                existenceFlg = true;
            }
        }
        if (!existenceFlg){
            return -1;
        }
        return sum;
    }
}
