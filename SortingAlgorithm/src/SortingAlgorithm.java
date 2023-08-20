
import java.util.*;

public class SortingAlgorithm {
    public static void main(String[] args) {
        final int listForSortingCount = 10_000;
        ArrayList<Integer> listForSorting = ListCommands.createArray();
        ListCommands.setRandom(listForSorting, listForSortingCount); // заполнение случайным значением
        System.out.println("Начальный список:");
        ListCommands.print(listForSorting);

        ArrayList<Integer> listSorted = listForSorting; // отсортированный список

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
        System.out.println("\nСортировка пузырьком затратила: " + (endTimeBubbleSort - startTimeBubbleSort) + " milliseconds");
//        System.out.println("Отсортированный список пузырьком:");
//        ListComands.print(listSorted);

        listSorted = listForSorting; //обновление на начальный список
        long startTimeCollectionsSort = System.currentTimeMillis();
        Collections.sort(listSorted);
        long endTimeCollectionsSort = System.currentTimeMillis();
        System.out.println("\nСортировка с помощью Collections.sort затратила: " + (endTimeCollectionsSort - startTimeCollectionsSort) + " milliseconds");
//        System.out.println("Отсортированный список с помощью Collections.sort:");
//        ListComands.print(listSorted);

        System.out.println("\nСортировка пузырьком списка из " + listForSortingCount + " элементов отработала дольше в " + (endTimeBubbleSort - startTimeBubbleSort)/(endTimeCollectionsSort - startTimeCollectionsSort) + " раз");
    }
}
