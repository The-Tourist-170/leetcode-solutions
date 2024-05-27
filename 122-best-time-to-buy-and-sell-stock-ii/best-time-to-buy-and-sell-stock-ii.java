class Solution {
    public int maxProfit(int[] p) {
        int pMax = 0;

        for(int i = 1; i < p.length; i++) {
            pMax += p[i] > p[i-1] ? p[i] - p[i-1] : 0;
        }

        return pMax;
    }
}