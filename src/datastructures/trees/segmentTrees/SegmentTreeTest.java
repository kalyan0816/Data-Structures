package datastructures.trees.segmentTrees;

import org.junit.jupiter.api.Test;
import utils.ArrayUtils;

class SegmentTreeTest {

    @Test
    void updateTestMax() {
        int testSize = ArrayUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = ArrayUtils.randomPositiveInt(30, 40);
            int[] array = ArrayUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.MAX);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = ArrayUtils.randomPositiveInt(0, size - 1);
                int y = ArrayUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = Integer.MIN_VALUE;
                int changeIndex = ArrayUtils.randomPositiveInt(0, size - 1);
                int changeValue = ArrayUtils.randomPositiveInt(-1000, 1000);
                array[changeIndex] = changeValue;
                segmentTree.update(changeIndex, changeValue);
                for (int index = x; index <= y; index++) {
                    maxFromIteration = Math.max(maxFromIteration, array[index]);
                }
                int maxFromSegTree = segmentTree.query(x, y);
                assert maxFromIteration == maxFromSegTree;
            }
        }
    }

    @Test
    void updateTestMin() {
        int testSize = ArrayUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = ArrayUtils.randomPositiveInt(30, 40);
            int[] array = ArrayUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.MIN);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = ArrayUtils.randomPositiveInt(0, size - 1);
                int y = ArrayUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = Integer.MAX_VALUE;
                int changeIndex = ArrayUtils.randomPositiveInt(0, size - 1);
                int changeValue = ArrayUtils.randomPositiveInt(-1000, 1000);
                array[changeIndex] = changeValue;
                segmentTree.update(changeIndex, changeValue);
                for (int index = x; index <= y; index++) {
                    maxFromIteration = Math.min(maxFromIteration, array[index]);
                }
                int maxFromSegTree = segmentTree.query(x, y);
                assert maxFromIteration == maxFromSegTree;
            }
        }
    }

    @Test
    void updateTestSum() {
        int testSize = ArrayUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = ArrayUtils.randomPositiveInt(30, 40);
            int[] array = ArrayUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.SUM);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = ArrayUtils.randomPositiveInt(0, size - 1);
                int y = ArrayUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = 0;
                int changeIndex = ArrayUtils.randomPositiveInt(0, size - 1);
                int changeValue = ArrayUtils.randomPositiveInt(-1000, 1000);
                array[changeIndex] = changeValue;
                segmentTree.update(changeIndex, changeValue);
                for (int index = x; index <= y; index++) {
                    maxFromIteration = maxFromIteration + array[index];
                }
                int maxFromSegTree = segmentTree.query(x, y);
                assert maxFromIteration == maxFromSegTree;
            }
        }
    }

    @Test
    void QueryTestMax() {
        int testSize = ArrayUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = ArrayUtils.randomPositiveInt(30, 40);
            int[] array = ArrayUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.MAX);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = ArrayUtils.randomPositiveInt(0, size - 1);
                int y = ArrayUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = Integer.MIN_VALUE;
                for (int index = x; index <= y; index++) {
                    maxFromIteration = Math.max(maxFromIteration, array[index]);
                }
                int maxFromSegTree = segmentTree.query(x, y);
                assert maxFromIteration == maxFromSegTree;
            }
        }
    }

    @Test
    void QueryTestMin() {
        int testSize = ArrayUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = ArrayUtils.randomPositiveInt(30, 40);
            int[] array = ArrayUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.MIN);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = ArrayUtils.randomPositiveInt(0, size - 1);
                int y = ArrayUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = Integer.MAX_VALUE;
                for (int index = x; index <= y; index++) {
                    maxFromIteration = Math.min(maxFromIteration, array[index]);
                }
                int maxFromSegTree = segmentTree.query(x, y);
                assert maxFromIteration == maxFromSegTree;
            }
        }
    }

    @Test
    void QueryTestSum() {
        int testSize = ArrayUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = ArrayUtils.randomPositiveInt(30, 40);
            int[] array = ArrayUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.SUM);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = ArrayUtils.randomPositiveInt(0, size - 1);
                int y = ArrayUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = 0;
                for (int index = x; index <= y; index++) {
                    maxFromIteration = maxFromIteration + array[index];
                }
                int maxFromSegTree = segmentTree.query(x, y);
                assert maxFromIteration == maxFromSegTree;
            }
        }
    }
}