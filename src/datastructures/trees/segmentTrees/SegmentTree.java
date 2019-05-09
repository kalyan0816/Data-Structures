package datastructures.trees.segmentTrees;

import java.util.Arrays;

public class SegmentTree {

    private final SegmentTreeType type;
    private int[] segTree;
    private int arraySize;
    private int segArraySize;
    private int[] array;

    SegmentTree(int[] array, SegmentTreeType treeType) {
        int n = array.length;
        this.array = array;
        arraySize = n;
        int size = getSize(n);
        segArraySize = size;
        segTree = new int[size];
        type = treeType;
        Arrays.fill(segTree, this.type.getDefaultValue());
        build(array, segTree, 0, n - 1, 0);
    }

    private void build(int[] array, int[] segTree, int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = array[low];
            return;
        }
        int mid = (low + high) / 2;
        build(array, segTree, low, mid, leftChildIndex(pos));
        build(array, segTree, mid + 1, high, rightChildIndex(pos));
        segTree[pos] = this.type.apply(segTree[leftChildIndex(pos)], segTree[rightChildIndex(pos)]);
    }

    public void update(int arrayIndex, int newValue) {
        int leafIndex = getLeafIndex(0, arraySize - 1, 0, arrayIndex);
        segTree[leafIndex] = newValue;
        array[arrayIndex] = newValue;
        int current = parentIndex(leafIndex);
        while (current >= 0) {
            segTree[current] = this.type.apply(segTree[leftChildIndex(current)], segTree[rightChildIndex(current)]);
            current = parentIndex(current);
        }
    }

    public int query(int lowInArray, int highInArray) {
        if (lowInArray > highInArray) {
            lowInArray = lowInArray + highInArray;
            highInArray = lowInArray - highInArray;
            lowInArray = lowInArray - highInArray;
        }
        if (lowInArray < 0 || highInArray > arraySize - 1) {
            throw new IllegalStateException("Invalid query range");
        }
        return query(0, arraySize - 1, lowInArray, highInArray, 0);
    }

    private int query(int lowInSeg, int highInSeg, int lowInArray, int highInArray, int pos) {
        if (lowInArray == highInArray) {
            return array[lowInArray];
        }
        if (perfectMatch(lowInSeg, highInSeg, lowInArray, highInArray)) {
            return segTree[pos];
        } else if (partialMatch(lowInSeg, highInSeg, lowInArray, highInArray)) {
            int mid = (lowInSeg + highInSeg) / 2;
            return this.type.apply(query(lowInSeg, mid, lowInArray, mid, leftChildIndex(pos)),
                    query(mid + 1, highInSeg, mid + 1, highInArray, rightChildIndex(pos)));
        }
        return this.type.getDefaultValue();
    }

    private boolean partialMatch(int lowInSeg, int highInSeg, int lowInArray, int highInArray) {
        return (lowInSeg <= lowInArray && lowInSeg <= highInArray) && (highInSeg >= lowInArray && highInSeg >= highInArray);
    }

    private boolean perfectMatch(int lowInSeg, int highInSeg, int lowInArray, int highInArray) {
        return (lowInSeg == lowInArray) && (highInSeg == highInArray);
    }

    private int getLeafIndex(int low, int high, int pos, int arrayIndex) {
        if (low == high && (low == arrayIndex)) {
            return pos;
        }
        int mid = (low + high) / 2;

        if (arrayIndex <= mid) {
            return getLeafIndex(low, mid, leftChildIndex(pos), arrayIndex);
        } else {
            return getLeafIndex(mid + 1, high, rightChildIndex(pos), arrayIndex);
        }
    }

    public void print() {
        for (int i = 0; i < segTree.length; i++) {
            System.out.print(segTree[i] + " ");
        }
    }

    private int getSize(int n) {
        return (int) (2 * (Math.pow(2, Math.ceil(Math.sqrt(n)))) - 1);
    }

    private int leftChildIndex(int x) {
        return 2 * x + 1;
    }

    private int rightChildIndex(int x) {
        return 2 * x + 2;
    }

    private int parentIndex(int x) {
        return (x == 0) ? -1 : (x - 1) / 2;
    }
}