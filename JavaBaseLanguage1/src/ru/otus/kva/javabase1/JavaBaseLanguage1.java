package ru.otus.kva.javabase1;

import java.util.Scanner;

public class JavaBaseLanguage1 {
    public static void main(String[] args) {
        int inNumber = 1;
        while (inNumber != 0) {
            System.out.println("\nВведите значение от 1 до 5. Для завершения работы введите 0. ");
            Scanner scanner = new Scanner(System.in);
            inNumber = scanner.nextInt();
            if (inNumber == 1) {
                greetings();
            } else if (inNumber == 2) {
                int a = randomInt(-100, 100);
                int b = randomInt(-100, 100);
                int c = randomInt(-100, 100);
                checkSign(a, b, c);
            } else if (inNumber == 3) {
                selectColor();
            } else if (inNumber == 4) {
                compareNumbers();
            } else if (inNumber == 5) {
                int initValue = randomInt(-100, 100);
                int delta = randomInt(-100, 100);
                //Выбор рандомного increment:
                //если рандомное число четное, то true, иначе false
                boolean increment = true;
                int incrementInt = randomInt(1, 100);
                if (incrementInt % 2 == 1) {
                    increment = false;
                }
                addOrSubtractAndPrint(initValue, delta, increment);
            } else if (inNumber != 0) {
                System.out.println("Введено некорректное число.");
            }
        }
        System.out.println("Благодарю за работу!");
    }

    //(1) Реализуйте метод greetings(), который при вызове должен отпечатать в столбец 4 слова: Hello, World, from, Java;
    public static void greetings() {
        System.out.println("\nМетод greetings");
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    //(2) Реализуйте метод checkSign(..), принимающий в качестве аргументов 3 int переменные a, b и c.
    // Метод должен посчитать их сумму, и если она больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
    // в противном случае - “Сумма отрицательная”;
    public static void checkSign(int a, int b, int c) {
        System.out.println("\nМетод checkSign");
        int result = a + b + c;
        System.out.println("Sum(" + a + ";" + b + ";" + c + ") = " + result);
        if (result >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //(3) Реализуйте метод selectColor() в теле которого задайте int переменную data с любым начальным значением.
    // Если data меньше 10 включительно, то в консоль должно быть выведено сообщение “Красный”,
    // если от 10 до 20 включительно, то “Желтый”,
    // если больше 20 - “Зеленый”;
    public static void selectColor() {
        System.out.println("\nМетод selectColor");
        int data = randomInt(-100, 100); // рандомное число в промежутке [-100,100)
        System.out.println("data = " + data);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    //(4) Реализуйте метод compareNumbers(), в теле которого объявите две int переменные a и b с любыми начальными значениями.
    // Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
    public static void compareNumbers() {
        System.out.println("\nМетод compareNumbers");
        int a = randomInt(-100, 100); // рандомное число в промежутке [-100,100)
        int b = randomInt(-100, 100); // рандомное число в промежутке [-100,100)
        System.out.println("a = " + a + "; b = " + b);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //(5) Создайте метод addOrSubtractAndPrint(int initValue, int delta, boolean increment).
    // Если increment = true, то метод должен к initValue прибавить delta и отпечатать в консоль результат,
    // в противном случае - вычесть;
    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println("\nМетод addOrSubtractAndPrint");
        System.out.println("initValue = " + initValue + "; delta = " + delta + "; increment = " + increment);
        int initValueRes = initValue;
        if (increment) {
            initValueRes += delta;
            System.out.println("result = " + initValueRes);
        } else {
            initValueRes -= delta;
            System.out.println("result = " + initValueRes);
        }
    }

    //метод для генерации рандомного числа в промежутке [min,max)
    public static int randomInt(int min, int max) {
        int result = min + (int) (Math.random() * (max - min + 1));
        return result;
    }
}
