import java.util.*;

class Solution {

    public int longestSubarray(int[] arr, int k) {

        int n = arr.length;
        int prefixSum = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            if (arr[i] > k)
                prefixSum += 1;
            else
                prefixSum -= 1;

            if (prefixSum > 0) {
                maxLen = i + 1;
            } 
          
            else if (map.containsKey(prefixSum - 1)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - 1));
            }

            map.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }
}