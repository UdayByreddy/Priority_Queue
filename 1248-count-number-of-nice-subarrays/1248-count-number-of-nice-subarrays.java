class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSubarrays(nums,k)-countSubarrays(nums,k-1);
    }
    public int countSubarrays(int[] nums, int k){
        int left=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1) k--;
            while(k<0){
                if(nums[left]%2==1)k++;
            left++;
            }
            count+=(i-left+1);
        }
        return count;
    }
}