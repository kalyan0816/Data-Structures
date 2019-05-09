package datastructures.trees.segmentTrees;

public class SegmentTreeTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 9, 11};
        SegmentTree segmentTree = new SegmentTree(array, SegmentTreeType.SUM);
        System.out.println(segmentTree.query(1, 3));
        segmentTree.update(1, 10);
        System.out.println(segmentTree.query(1, 3));
    }
}