import java.util.*;

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int idx = stack.pop();
                ans += (i - idx);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            ans += (n - idx);
        }

        return ans;
    }
}