class Solution {
    public void moveZeroes(int[] nums) {

        int j =0;
        int[] tmp = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            if(nums[i] != 0){
                 
                    tmp[j] = nums[i]; 
                    j++;
            }
               
            
           
        }
        for(int k =0;k<tmp.length; k++)
        nums[k] = tmp[k];
    }
}