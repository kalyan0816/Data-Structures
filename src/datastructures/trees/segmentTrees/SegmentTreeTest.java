package datastructures.trees.segmentTrees;

import org.junit.jupiter.api.Test;
import utils.RandomUtils;

class SegmentTreeTest {

    @Test
    void updateTestMax() {
        int testSize = RandomUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = RandomUtils.randomPositiveInt(30, 40);
            int[] array = RandomUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.MAX);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = RandomUtils.randomPositiveInt(0, size - 1);
                int y = RandomUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = Integer.MIN_VALUE;
                int changeIndex = RandomUtils.randomPositiveInt(0, size - 1);
                int changeValue = RandomUtils.randomPositiveInt(-1000, 1000);
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
        int testSize = RandomUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = RandomUtils.randomPositiveInt(30, 40);
            int[] array = RandomUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.MIN);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = RandomUtils.randomPositiveInt(0, size - 1);
                int y = RandomUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = Integer.MAX_VALUE;
                int changeIndex = RandomUtils.randomPositiveInt(0, size - 1);
                int changeValue = RandomUtils.randomPositiveInt(-1000, 1000);
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
        int testSize = RandomUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = RandomUtils.randomPositiveInt(30, 40);
            int[] array = RandomUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.SUM);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = RandomUtils.randomPositiveInt(0, size - 1);
                int y = RandomUtils.randomPositiveInt(0, size - 1);
                if (x > y) {
                    x = x + y;
                    y = x - y;
                    x = x - y;
                }
                int maxFromIteration = 0;
                int changeIndex = RandomUtils.randomPositiveInt(0, size - 1);
                int changeValue = RandomUtils.randomPositiveInt(-1000, 1000);
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
    void QueryTest() {
        int testSize = RandomUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = RandomUtils.randomPositiveInt(30, 40);
            int[] array = RandomUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.MAX);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = RandomUtils.randomPositiveInt(0, size - 1);
                int y = RandomUtils.randomPositiveInt(0, size - 1);
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
        int testSize = RandomUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = RandomUtils.randomPositiveInt(30, 40);
            int[] array = RandomUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.MIN);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = RandomUtils.randomPositiveInt(0, size - 1);
                int y = RandomUtils.randomPositiveInt(0, size - 1);
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
        int testSize = RandomUtils.randomPositiveInt(5, 10);
        for (int testNo = 0; testNo < testSize; testNo++) {
            int size = RandomUtils.randomPositiveInt(30, 40);
            int[] array = RandomUtils.randomIntArray(size, -1000, 1000);
            SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.SUM);
            for (int testCaseNo = 0; testCaseNo <= size; testCaseNo++) {
                int x = RandomUtils.randomPositiveInt(0, size - 1);
                int y = RandomUtils.randomPositiveInt(0, size - 1);
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