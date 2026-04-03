class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left=0;
        int right =0;
        int maxCount=0;
        int n = s.length();
        int ans =0;
        while(right<n){
            freq[s.charAt(right)-'A']++;
            maxCount = Math.max(maxCount,freq[s.charAt(right)-'A']);
            while(Math.abs(maxCount-(right-left+1))>k){
                freq[s.charAt(left)-'A']--;
                left++;
                maxCount = Math.max(maxCount,freq[s.charAt(right)-'A']);
            }
            ans = Math.max(ans,(right-left+1));
            right++;
        }
        return ans;

        
    }
}