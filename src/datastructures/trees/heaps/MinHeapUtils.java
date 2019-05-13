package datastructures.trees.heaps;

import utils.RandomUtils;

public class MinHeapUtils {

    public static void main(String[] args) {
        MinIntHeap minIntHeap = new MinIntHeap();
        int size = RandomUtils.randomPositiveInt(6, 10);
        int[] items = RandomUtils.randomPositiveIntArray(size);
        for (int i = 0; i < size; i++) {
            minIntHeap.add(items[i]);
        }
        for (int i = 0; i < size; i++) {
            System.out.println(minIntHeap.poll());
        }
    }
}