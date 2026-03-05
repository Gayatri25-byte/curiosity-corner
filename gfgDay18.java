class Solution {

    public int longestKSubstr(String s, int k) {

        int n = s.length();
        int left = 0;
        int maxLen = -1;

        int[] freq = new int[26];
        int distinct = 0;

        for (int right = 0; right < n; right++) {

            int idx = s.charAt(right) - 'a';

            if (freq[idx] == 0) {
                distinct++;
            }

            freq[idx]++;

            while (distinct > k) {
                int leftIdx = s.charAt(left) - 'a';
                freq[leftIdx]--;

                if (freq[leftIdx] == 0) {
                    distinct--;
                }

                left++;
            }

            if (distinct == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}