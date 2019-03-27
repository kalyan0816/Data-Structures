package utils;

import java.util.Random;
import java.util.Scanner;

public class ArrayUtils {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static int[] readArray(int arraySize) {
        int[] array = new int[arraySize];
        for (int index = 0; index < arraySize; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] = array[i] + array[j];
        array[j] = array[i] - array[j];
        array[i] = array[i] - array[j];
    }

    public static void printArray(int[] array, char separator) {
        for (int item : array) {
            System.out.print(item + "" + separator);
        }
        System.out.println();
    }

    public static int randomPositiveInt(int lowerBound, int upperBound) {
        int randInt = Math.abs(random.nextInt(upperBound - lowerBound + 1) + lowerBound);
        System.out.println(randInt);
        return randInt;
    }

    public static int[] randomIntArray(int arraySize, int lowerBound, int upperBound) {
        int[] randArray = random.ints(arraySize, lowerBound, upperBound).toArray();
        printArray(randArray, ' ');
        return randArray;
    }

    public static int[] randomIntArray(int arraySize) {
        return randomIntArray(arraySize, -100, 100);
    }

    public static int[] randomPositiveIntArray(int arraySize) {
        return randomIntArray(arraySize, 1, 100);
    }

    public static int[] randomPositiveNegitiveIntArray(int arraySize) {
        return randomIntArray(arraySize, -100, -1);
    }

    public static int randomPositiveInt() {
        return randomPositiveInt(1, 100);
    }

    public static int randomNegitiveInt() {
        return randomPositiveInt(-100, -1);
    }

    public static int randomInt() {
        return randomPositiveInt(-100, 100);
    }

    public static int readInt() {
        return scanner.nextInt();
    }
}
