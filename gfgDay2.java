import java.util.*;

class Solution {

    int overlapInt(int[][] intervals) {

        TreeMap<Integer, Integer> events = new TreeMap<>();

        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            events.put(start, events.getOrDefault(start, 0) + 1);
            
            events.put(end + 1, events.getOrDefault(end + 1, 0) - 1);
        }

        int current = 0;
        int maxOverlap = 0;

        
        for (int change : events.values()) {
            current += change;
            maxOverlap = Math.max(maxOverlap, current);
        }

        return maxOverlap;
    }
}