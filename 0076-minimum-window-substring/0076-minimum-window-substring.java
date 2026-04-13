class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int[] map = new int[128];
        for(char ch:t.toCharArray()){
            map[ch]++;
        }
        int count = t.length();
        int start =0;
        int end=0;
        int maxLen = Integer.MAX_VALUE;
        char[] ch = s.toCharArray();
        int startIndex=0;
        while(end<s.length()){
            if(map[ch[end++]]-->0){
                count--;
            }
            while(count==0){
                if(end-start<maxLen){
                    startIndex = start;
                    maxLen = end-start;
                }
                if(map[ch[start++]]++==0){
                    count++;
                }
            }
        }
         return maxLen == Integer.MAX_VALUE?"":new String(ch,startIndex,maxLen);
    }

}