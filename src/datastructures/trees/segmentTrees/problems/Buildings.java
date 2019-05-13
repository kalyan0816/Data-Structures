package datastructures.trees.segmentTrees.problems;

import datastructures.trees.segmentTrees.SegmentTree;
import datastructures.trees.segmentTrees.SegmentTreeType;
import utils.RandomUtils;

public class Buildings {

    public static void main(String[] args) {

        int buildings = 6;
        int[] coordinates = new int[]{5, 9, 15, 17, 19, 25};
        int[] heights = new int[]{6, 2, 10, 3, 3, 7};

        int[] fallCoordinates = new int[buildings];
        for (int i = 0; i < buildings; i++) {
            fallCoordinates[i] = coordinates[i] + heights[i];
        }
        SegmentTree segmentTree = new SegmentTree(fallCoordinates, SegmentTreeType.MAX);
        for (int coordinateIndex = buildings - 2; coordinateIndex >= 0; coordinateIndex--) {
            int coordinateOfFarthestBuildingItCanFall = coordinateOfFarthestBuildingItCanFall(coordinates, coordinateIndex, buildings - 1, fallCoordinates[coordinateIndex]);
            int highestFallBetweenRange = segmentTree.query(coordinateIndex, coordinateOfFarthestBuildingItCanFall);
            if (fallCoordinates[coordinateIndex] != highestFallBetweenRange) {
                fallCoordinates[coordinateIndex] = highestFallBetweenRange;
                segmentTree.update(coordinateIndex, highestFallBetweenRange);
            }
        }
        RandomUtils.printArray(fallCoordinates, '\n');
    }

    private static int coordinateOfFarthestBuildingItCanFall(int[] coordinates, int low, int high, int fallCoordinate) {

        boolean currentFarthestFound = false;
        int currentFarthestValue = Integer.MIN_VALUE;
        int currentFarthestCoordinate = Integer.MIN_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (coordinates[mid] == fallCoordinate) {
                return mid;
            } else if (coordinates[mid] < fallCoordinate) {
                if (!currentFarthestFound) {
                    currentFarthestFound = true;
                    currentFarthestCoordinate = mid;
                    currentFarthestValue = coordinates[mid];
                } else if ((fallCoordinate - coordinates[mid]) < (fallCoordinate - currentFarthestValue)) {
                    currentFarthestValue = coordinates[mid];
                    currentFarthestCoordinate = mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return currentFarthestCoordinate;
    }
}