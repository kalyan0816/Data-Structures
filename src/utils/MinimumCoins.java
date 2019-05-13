package utils;

public class MinimumCoins {

    public static void main(String[] args) {

        int t = FastReader.nextInt();
        for (int t0 = t; t0 > 0; t0--) {
            int n = FastReader.nextInt();
            int[] denos = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
            int[] minCoins = getMinCoins(denos, n);
            for (int i = minCoins.length - 1; i >= 0; i--) {
                if (minCoins[i] <= 0) continue;
                for (int j = 0; j < minCoins[i]; j++) {
                    System.out.print(denos[i] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[] getMinCoins(int[] denos, int n) {
        int[] coinsRequired = new int[10];
        while (n > 0) {
            int highestDenoIndexLessThanN = getHighestDenoIndexLessThanN(denos, n);
            coinsRequired[highestDenoIndexLessThanN] = n / denos[highestDenoIndexLessThanN];
            n = n % denos[highestDenoIndexLessThanN];
        }
        return coinsRequired;
    }

    private static int getHighestDenoIndexLessThanN(int[] denos, int n) {
        int low = 0, high = 9;

        int nearestUptoNow = -1;
        int nearestUptoNowIndex = -1;
        boolean nearestFound = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (denos[mid] == n) {
                return mid;
            } else if (denos[mid] > n) {
                high = mid - 1;
            } else {
                if (!nearestFound) {
                    nearestFound = true;
                    nearestUptoNow = denos[mid];
                    nearestUptoNowIndex = mid;
                } else {
                    if ((n - denos[mid]) < (n - nearestUptoNow)) {
                        nearestUptoNow = denos[mid];
                        nearestUptoNowIndex = mid;
                    }
                }
                low = mid + 1;
            }
        }
        return nearestUptoNowIndex;
    }
}