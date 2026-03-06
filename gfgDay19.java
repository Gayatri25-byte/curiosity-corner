class Solution {

    public String minWindow(String s, String p) {

        if (p.length() > s.length()) return "";

        int[] freq = new int[256];

        for (char c : p.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char r = s.charAt(right);

            if (freq[r] > 0) {
                count--;
            }

            freq[r]--;
            right++;

            while (count == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                freq[l]++;

                if (freq[l] > 0) {
                    count++;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";

        return s.substring(start, start + minLen);
    }
}
