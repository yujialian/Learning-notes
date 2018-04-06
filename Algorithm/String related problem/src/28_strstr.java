class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        if(needle.length() == 0) return 0;
        if(haystack.equals(needle)) return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
//KMP?
