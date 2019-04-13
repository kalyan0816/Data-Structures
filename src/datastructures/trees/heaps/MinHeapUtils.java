package datastructures.trees.heaps;

import utils.ArrayUtils;

public class MinHeapUtils {

    public static void main(String[] args) {
        MinIntHeap minIntHeap = new MinIntHeap();
        int size = ArrayUtils.randomPositiveInt(6, 10);
        int[] items = ArrayUtils.randomPositiveIntArray(size);
        for (int i = 0; i < size; i++) {
            minIntHeap.add(items[i]);
        }
        for (int i = 0; i < size; i++) {
            System.out.println(minIntHeap.poll());
        }
    }
}