class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (m > n) return ans;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < m; i++) {
            need[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < n; right++) {
            window[s.charAt(right) - 'a']++;

            if (right - left + 1 > m) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == m) {
                boolean same = true;
                for (int i = 0; i < 26; i++) {
                    if (need[i] != window[i]) {
                        same = false;
                        break;
                    }
                }
                if (same) ans.add(left);
            }
        }

        return ans;
    }
}