class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        int[] map = new int[26];

        for (int i = 0; i < order.length(); ++i) {
            char c = order.charAt(i);
            map[c - 'a'] = i;
        }

        System.out.println("map=" + Arrays.toString(map));

        for (int i = 1; i < n; ++i)
            if (!compare(words[i - 1], words[i], map))
                return false;
        
        return true;
    }

    private boolean compare(String a, String b, int[] map) {
        for (int i = 0; i < a.length() && i < b.length(); ++i) {
            if (Integer.compare(map[a.charAt(i) - 'a'], map[b.charAt(i) - 'a']) > 0) {
                return false;
            } else if (Integer.compare(map[a.charAt(i) - 'a'], map[b.charAt(i) - 'a']) < 0) {
                return true;
            }
        }
        
        return a.length() <= b.length();
    }
}