class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        // last[i] = last index where character with ASCII i appears
        int[] last = new int[256];
        for (int i = 0; i < n; i++) {
            last[s.charAt(i)] = i;
        }

        boolean[] seen = new boolean[256];      // whether char is already in result
        StringBuilder stack = new StringBuilder();  // acts as a monotonic stack

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // if already taken, skip (we want each distinct char exactly once)
            if (seen[c]) {
                continue;
            }

            // while top of stack is lexicographically larger than current char
            // and that top char appears again later, we can pop it to get
            // a lexicographically smaller result
            while (stack.length() > 0) {
                char top = stack.charAt(stack.length() - 1);
                if (top > c && last[top] > i) {
                    seen[top] = false;
                    stack.deleteCharAt(stack.length() - 1);
                } else {
                    break;
                }
            }

            stack.append(c);
            seen[c] = true;
        }

        return stack.toString();
    }
}