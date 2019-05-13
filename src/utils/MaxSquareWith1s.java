package utils;

//  https://www.youtube.com/watch?v=FO7VXDfS8Gk

public class MaxSquareWith1s {

    private static final int ELEMENT = 0;
    private static final int AREA = 1;

    public static void main(String[] args) {

        int n = FastReader.nextInt();
        int m = FastReader.nextInt();

        int[][][] mat = new int[n + 1][m + 1][2];
        int maxArea = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mat[i][j][ELEMENT] = FastReader.nextInt();
                if (mat[i][j][ELEMENT] == 1) {
                    mat[i][j][AREA] = getArea(mat, i, j);
                }
                maxArea = Math.max(maxArea, mat[i][j][AREA]);
            }
        }
        System.out.println(maxArea);
    }

    private static int getArea(int[][][] mat, int i, int j) {
        int area = Integer.MAX_VALUE;
        area = Math.min(area, mat[i - 1][j][AREA]);
        area = Math.min(area, mat[i][j - 1][AREA]);
        area = Math.min(area, mat[i - 1][j - 1][AREA]);
        return (int) Math.pow(Math.sqrt(area) + 1, 2);
    }
}

