import java.util.*;
public class ListCommands {

    //создание списка
    public static ArrayList<Integer> createArray() {
        ArrayList<Integer> list = new ArrayList<>();
        return list;
    }

    //наполнение рандомными значения коллекции collection размером count
    public static void setRandom(Collection<Integer> collection, int count) {
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            collection.add(r.nextInt(-1_000_000,1_000_000));
        }
    }

    //вывод на экран
    public static void print(Iterable<Integer> collection) {
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
