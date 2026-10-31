import java.util.*;

class Solution {
    public int minSteps(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        int i = 0, j = 0;
        int cnt = 0;

        while (i < n1 && j < n2) {
            if (s1[i] == t1[j]) {
                i++;
                j++;
            } else if (s1[i] > t1[j]) {
                cnt++;
                j++;
            } else {
                i++;
            }
        }

        return cnt + (n2 - j); // Count remaining unmatched characters in t1
    }
}