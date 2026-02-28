import java.util.*;

class Solution {

    public ArrayList<Integer> findClosestPair(int[] arr1, int[] arr2, int x) {

        int i = 0;
        int j = arr2.length - 1;

        int minDiff = Integer.MAX_VALUE;
        int a = 0, b = 0;

        while (i < arr1.length && j >= 0) {

            int sum = arr1[i] + arr2[j];
            int diff = Math.abs(sum - x);

            if (diff < minDiff) {
                minDiff = diff;
                a = arr1[i];
                b = arr2[j];
            }

            if (sum > x) {
                j--;
            } else {
                i++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        return res;
    }
}