import java.util.*;

class Solution {
    public boolean canAttend(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < arr[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
