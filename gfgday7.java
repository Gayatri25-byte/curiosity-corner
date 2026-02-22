import java.util.*;

class Solution {

    public static int subarrayXor(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int xor = 0;
        int count = 0;

        map.put(0, 1);

        for (int num : arr) {
            xor ^= num;

            int required = xor ^ k;
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}