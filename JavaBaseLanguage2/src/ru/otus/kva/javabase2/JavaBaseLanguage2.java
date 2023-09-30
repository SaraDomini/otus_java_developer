package ru.otus.kva.javabase2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class JavaBaseLanguage2 {
    public static void main(String[] args) {
        printStringNTimes(0, "Я пузатый апельсин");
        printStringNTimes(3, "А я томат");

        System.out.print("----------------------------------------");

        int[] arrIntSum = {1, 3, 5, 7, 8, 7, 5, 3, 1};
        sumArray(arrIntSum);
        sumArray(1, 2, 3, 4, 5);

        System.out.print("----------------------------------------");

        int[] arrInt = new int[5];
        setArray(3, arrInt);
        System.out.println("После метода: " + Arrays.toString(arrInt));

        System.out.print("----------------------------------------");

        setIncreaseArgs(10, arrIntSum);
        System.out.println("После метода: " + Arrays.toString(arrIntSum));
        setIncreaseArgs(10, 1);

        System.out.print("----------------------------------------");

        compareHalvesArray(arrIntSum);
        compareHalvesArray(1, 2, 3);
        compareHalvesArray(1, 2, 3, 4);

        System.out.print("----------------------------------------");

        int[] a = {1, 2, 3};
        int[] b = {2, 2};
        int[] c = {1, 1, 1, 1, 1};
        sumArrays(a, b, c);

        System.out.print("----------------------------------------");

        checkPointArray(1, 1, 1, 1, 1, 5);
        checkPointArray(5, 3, 4, -2);
        checkPointArray(7, 2, 2, 2);

        System.out.print("----------------------------------------");

        checkOrder(true, 1, 4, 7, 9, 15);
        checkOrder(true, 1, 4, 7, 15, 9);
        checkOrder(false, 15, 7, 4, 1, 9);
        checkOrder(false, 15, 9, 7, 4, 1);

        System.out.print("----------------------------------------");

        overturnArray(1, 2, 3, 4, 5);
        overturnArray(5, 4, 3, 2, 1);
        overturnArray(1, 6, 3, 2);
    }

    //Реализуйте метод, принимающий в качестве аргументов целое число и строку,
    // и печатающий в консоль строку указанное количество раз;
    public static void printStringNTimes(int n, String string) {
        System.out.println("\nМетод printStringNTimes(" + n + ", " + string + ")");
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                System.out.println(i + ". " + string);
            }
        } else {
            System.out.println("Указано не корректное кол-во раз.");
        }
    }

    // Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
    // суммирующий все элементы, значение которых больше 5, и печатающий полученную сумму в консоль;
    public static void sumArray(int... arg) {
        System.out.println("\nМетод sumArray(" + Arrays.toString(arg) + ")");
        int sum = 0;
        for (int i = 0; i < arg.length; i++) {
            if (arg[i] > 5) {
                sum += arg[i];
            }
        }
        System.out.println("Сумма элементов, значение которых больше 5: " + sum);
    }

    // Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
    // метод должен заполнить каждую ячейку массива указанным числом;
    public static void setArray(int a, int... arg) {
        System.out.println("\nМетод setArray(" + a + ", " + Arrays.toString(arg) + ")");
        for (int i = 0; i < arg.length; i++) {
            arg[i] = a;
        }
        System.out.println("Из метода: " + Arrays.toString(arg));
    }


    // Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на целочисленный массив,
    // увеличивающий каждый элемент массива на указанное число;
    public static void setIncreaseArgs(int n, int... args) {
        System.out.println("\nМетод setIncreaseArgs(" + n + ", " + Arrays.toString(args) + ")");
        for (int i = 0; i < args.length; i++) {
            args[i] += n;
        }
        System.out.println("Из метода: " + Arrays.toString(args));
    }


    // Реализуйте метод, принимающий в качестве аргумента целочисленный массив,
    // и печатающий в консоль информацию о том, сумма элементов какой из половин массива больше;
    public static void compareHalvesArray(int... arg) {
        System.out.println("\nМетод compareHalvesArray(" + Arrays.toString(arg) + ")");
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= arg.length - i - 1; i++) {
            if (i == (arg.length - i - 1)) {
                sum1 += arg[i]; //средний элемент прибавляем в левую (первую) часть
            } else {
                sum1 += arg[i];
                sum2 += arg[arg.length - i - 1];
            }
//            System.out.println(i + "; arg[" + i + "] = " + arg[i] + "; arg[" + (arg.length - i - 1) + "] = "
//                    + arg[arg.length - i - 1] + "; sum1 = " + sum1 + "; sum2 = " + sum2);
        }
        if (sum1 > sum2) {
            System.out.println("Cумма элементов левой (первой) половины массива больше");
        } else if (sum1 < sum2) {
            System.out.println("Cумма элементов правой (второй) половины массива больше");
        } else {
            System.out.println("Cуммы элементов обоих половин массива равны");
        }
    }


    //Реализуйте метод, принимающий на вход набор целочисленных массивов,
    // и получающий новый массив равный сумме входящих;
    // Пример: { 1, 2, 3 } + { 2, 2 } + { 1, 1, 1, 1, 1} = { 4, 5, 4, 1, 1 }
    public static void sumArrays(int[]... arr) {
        //Вывод
        System.out.print("\nМетод sumArrays(");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(Arrays.toString(arr[i]));
            } else {
                System.out.print(Arrays.toString(arr[i]) + ", ");
            }
        }
        System.out.println(")");

        //инициализация суммарного массива
        int nMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (nMax < arr[i].length) {
                nMax = arr[i].length;
            }
        }
        int[] sum = new int[nMax];

        //вычисление суммы
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum[j] += arr[i][j];
                //System.out.println("i = " + i + "; j = " + j + "; sum[j] = " + sum[j]);
            }
        }
        System.out.println("sum = " + Arrays.toString(sum));
    }


    //Реализуйте метод, проверяющий, что есть “точка” в массиве,
    // в которой сумма левой и правой части равны.
    // “Точка находится между элементами”;
    // Пример: { 1, 1, 1, 1, 1, | 5 }, { 5, | 3, 4, -2 }, { 7, 2, 2, 2 }, { 9, 4 }
    public static void checkPointArray(int... arr) {
        System.out.println("\nМетод checkPointArray(" + Arrays.toString(arr) + ")");
        int sum1 = 0;
        int sum2 = 0;
        int point = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            sum1 += arr[i];
            sum2 = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sum2 += arr[j];
            }
            //System.out.println("sum1 = " + sum1 + "; sum2 = " + sum2);
            if (sum1 == sum2) {
                point = i;
                break;
            }
        }

        System.out.print("Итоговый массив: {");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
            if (point == i) {
                System.out.print(" |");
            }
        }
        System.out.println(" }");

    }

    //Реализуйте метод, проверяющий, что все элементы массива идут в порядке убывания или возрастания
    // (по выбору пользователя)
    public static void checkOrder(boolean orderIndex, int... arr) {
        System.out.print("\nМетод checkOrder(");
        if (orderIndex) {
            System.out.print("возрастание, ");
        } else {
            System.out.print("убывание, ");
        }
        System.out.println(Arrays.toString(arr) + ")");

        boolean checkOrderResult = true;
        if (orderIndex) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    checkOrderResult = false;
                    break;
                }
            }
            if (checkOrderResult) {
                System.out.println("Элементы расположены в порядке возрастания.");
            } else {
                System.out.println("Элементы расположены НЕ в порядке возрастания.");
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    checkOrderResult = false;
                    break;
                }
            }
            if (checkOrderResult) {
                System.out.println("Элементы расположены в порядке убывания.");
            } else {
                System.out.println("Элементы расположены НЕ в порядке убывания.");
            }
        }
    }

    //Реализуйте метод, “переворачивающий” входящий массив Пример: { 1 2 3 4 } => { 4 3 2 1 }
    public static void overturnArray(int... arr) {
        System.out.println("\nМетод overturnArray(" + Arrays.toString(arr) + ")");
        int k = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            k = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = k;
            //System.out.println("i = " + i + "; " + Arrays.toString(arr));
        }
        System.out.println("Результат: " + Arrays.toString(arr));
    }
}

