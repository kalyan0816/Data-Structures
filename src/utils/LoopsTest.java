package utils;

import java.util.*;

public class LoopsTest {

    private static List<Integer> integers = new LinkedList<>();

    static {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            integers.add(i);
        }
    }

    public static void main(String[] args) {

        long start, end;
        // iterator
        start = Calendar.getInstance().getTimeInMillis();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
        }
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time took for iterator  : " + (end - start) + " ms");

        // for each
        start = Calendar.getInstance().getTimeInMillis();
        for (Integer integer : integers) {
            Integer next = integer;
        }
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time took for for  each : " + (end - start) + " ms");

        // for loop 1
        start = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < integers.size(); i++) {
            Integer next = integers.get(i);
        }
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time took for for loop1 : " + (end - start) + " ms");

        // for loop 2
        start = Calendar.getInstance().getTimeInMillis();
        int size = integers.size();
        for (int i = 0; i < size; i++) {
            Integer next = integers.get(i);
        }
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time took for for loop2 : " + (end - start) + " ms");

        // for loop 3
        start = Calendar.getInstance().getTimeInMillis();
        for (int i = integers.size() - 1; i >= 0; i--) {
            Integer next = integers.get(i);
        }
        end = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time took for for loop3 : " + (end - start) + " ms");
    }
}