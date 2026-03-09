import java.util.*;

class Solution {
    public boolean pythagoreanTriplet(int[] arr) {
        int n = arr.length;
        int maxVal = 0;
        
        for(int val : arr) {
            maxVal = Math.max(maxVal, val);
        }
        
        int[] freq = new int[maxVal + 1];
        for(int val : arr) {
            freq[val]++;
        }
        
        Set<Integer> squares = new HashSet<>();
        for(int i = 1; i <= maxVal; i++) {
            squares.add(i * i);
        }
        
        for(int a = 1; a <= maxVal; a++) {
            if(freq[a] == 0) continue;
            for(int b = a; b <= maxVal; b++) {
                if(freq[b] == 0) continue;
                int c2 = a*a + b*b;
                if(squares.contains(c2)) {
                    int c = (int)Math.sqrt(c2);
                    if(c*c == c2 && freq[c] > 0) {
                        // Ensure distinct indices if a == b == c
                        if((a == b && b == c && freq[a] >= 3) ||
                           (a == b && b != c && freq[a] >= 2 && freq[c] >= 1) ||
                           (a != b && b == c && freq[b] >= 2 && freq[a] >= 1) ||
                           (a != b && a == c && freq[a] >= 2 && freq[b] >= 1) ||
                           (a != b && b != c && a != c)) {
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}