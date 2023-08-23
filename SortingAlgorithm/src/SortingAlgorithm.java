
import java.util.*;

public class SortingAlgorithm {
    public static void main(String[] args) {
        final int listForSortingCount = 100; // размер списка
        ArrayList<Integer> listForSorting = ListCommands.createArray();
        ArrayList<Integer> listSorted = ListCommands.createArray(); // отсортированный список

        final int repeatCount = 30; // сколько раз
        double timeBubbleSortAVG = 0;
        double timeCollectionsSortAVG = 0; // среднее время обработки

        for (int k = 0; k < repeatCount; k++) {

            listForSorting.clear();
            listSorted.clear();
            ListCommands.setRandom(listForSorting, listForSortingCount); // заполнение случайным значением
            System.out.println("Начальный список:");
            ListCommands.print(listForSorting);

            listSorted = listForSorting;

            // сортировка пузырьком
            long startTimeBubbleSort = System.currentTimeMillis();
            int a1, a2;
            for (int i = listForSortingCount - 1; i > 0 ; i--) {
                for (int j = 0; j < i; j++) {
                    a1 = listSorted.get(j);
                    a2 = listSorted.get(j+1);
                    if (a1 > a2){
                        listSorted.set(j, a2);
                        listSorted.set(j+1, a1);
                    }
                }
            }
            long endTimeBubbleSort = System.currentTimeMillis();
            timeBubbleSortAVG += endTimeBubbleSort - startTimeBubbleSort;
            System.out.println("\nСортировка пузырьком затратила: " + (endTimeBubbleSort - startTimeBubbleSort) + " milliseconds");
    //        System.out.println("Отсортированный список пузырьком:");
    //        ListCommands.print(listSorted);
            System.out.println("timeBubbleSortAVG = " + timeBubbleSortAVG);

            listSorted = listForSorting; //обновление на начальный список
            long startTimeCollectionsSort = System.currentTimeMillis();
            Collections.sort(listSorted);
            long endTimeCollectionsSort = System.currentTimeMillis();
            timeCollectionsSortAVG += endTimeCollectionsSort - startTimeCollectionsSort;
            System.out.println("\nСортировка с помощью Collections.sort затратила: " + (endTimeCollectionsSort - startTimeCollectionsSort) + " milliseconds");
    //        System.out.println("Отсортированный список с помощью Collections.sort:");
    //        ListCommands.print(listSorted);
            System.out.println("timeCollectionsSortAVG = " + timeCollectionsSortAVG);

            System.out.println("\nСортировка пузырьком списка из " + listForSortingCount + " элементов отработала дольше на " +
                    ((endTimeBubbleSort - startTimeBubbleSort)-(endTimeCollectionsSort - startTimeCollectionsSort)) + " миллисекунд");
        }
        timeBubbleSortAVG = (double) timeBubbleSortAVG/repeatCount;
        timeCollectionsSortAVG = (double) timeCollectionsSortAVG/repeatCount;
        System.out.println("Среднее время обработки сортировки пузырьком списка из " + listForSortingCount + " элементов: " + timeBubbleSortAVG);
        System.out.println("Среднее время обработки Collections.sort списка из " + listForSortingCount + " элементов: " + timeCollectionsSortAVG);
        System.out.println("Сортировка пузырьком списка из " + listForSortingCount + " элементов в среднем отработала дольше, чем Collections.sort на " +
                        (timeBubbleSortAVG-timeCollectionsSortAVG) + " миллисекунд");
        listForSorting.clear();
        listSorted.clear();
    }
}
