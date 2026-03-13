import java.util.*;

class Solution {

    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(s, 0, 0, "", res);
        return res;
    }

    private void backtrack(String s, int index, int parts, String current, ArrayList<String> res) {

        if (parts == 4 && index == s.length()) {
            res.add(current.substring(0, current.length() - 1));
            return;
        }

        if (parts == 4 || index == s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String segment = s.substring(index, index + len);

            if ((segment.length() > 1 && segment.charAt(0) == '0') ||
                Integer.parseInt(segment) > 255) {
                continue;
            }

            backtrack(s, index + len, parts + 1, current + segment + ".", res);
        }
    }
}
