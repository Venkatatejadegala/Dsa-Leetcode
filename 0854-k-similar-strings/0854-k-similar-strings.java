import java.util.*;
class Solution {
    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.offer(s1);
        seen.add(s1);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int t = 0; t < size; t++) {
                String cur = q.poll();
                if (cur.equals(s2)) return steps;
                int i = 0;
                while (cur.charAt(i) == s2.charAt(i)) i++;
                char[] arr = cur.toCharArray();
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == s2.charAt(i) && arr[j] != s2.charAt(j)) {
                        swap(arr, i, j);
                        String next = new String(arr);
                        if (seen.add(next)) {
                            q.offer(next);
                        }
                        swap(arr, i, j);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}