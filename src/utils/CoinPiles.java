package utils;

public class CoinPiles {

    public static void main(String[] args) {

        int t = FastReader.nextInt();
        for (int t0 = 0; t0 < t; t0++) {
            int n = FastReader.nextInt();
            int k = FastReader.nextInt();
            int[] piles = new int[n];
            for (int n0 = 0; n0 < n; n0++) {
                piles[n0] = FastReader.nextInt();
            }
            int minCoinsToRemove = getMinCoinsToRemove(k, piles);
            System.out.println(minCoinsToRemove);
        }
    }

    private static int getMinCoinsToRemove(int k, int[] piles) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = piles.length - 1; i >= 0; i--) {
            min = Math.min(min, piles[i]);
            max = Math.max(max, piles[i]);
        }

        if (max <= k) {
            return 0;
        }
        int coinsToBeRemoved = Integer.MAX_VALUE;
        for (int frameBottom = 0, frameTop = k; frameTop <= max; frameBottom++, frameTop++) {
            int tempCoinsToBeRemoved = 0;
            for (int pile : piles) {
                int coinsBelow = 0;
                int coinsAbove = 0;
                if (pile < frameBottom) {
                    coinsBelow = pile;
                }
                if (pile > frameTop) {
                    coinsAbove = pile - frameTop;
                }
                tempCoinsToBeRemoved += coinsBelow;
                tempCoinsToBeRemoved += coinsAbove;
            }
            coinsToBeRemoved = Math.min(tempCoinsToBeRemoved, coinsToBeRemoved);
        }
        return coinsToBeRemoved;
    }
}