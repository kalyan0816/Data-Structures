package datastructures.trees.segmentTrees;

import java.util.function.BiFunction;

public enum SegmentTreeType {
    MIN(Math::min, Integer.MAX_VALUE),
    MAX(Math::max, Integer.MIN_VALUE),
    SUM(Integer::sum, 0);

    private BiFunction<Integer, Integer, Integer> operation;
    private Integer defaultValue;

    SegmentTreeType(BiFunction<Integer, Integer, Integer> operation, Integer defaultValue) {
        this.operation = operation;
        this.defaultValue = defaultValue;
    }

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public Integer apply(Integer x, Integer y) {
        return operation.apply(x, y);
    }
}
