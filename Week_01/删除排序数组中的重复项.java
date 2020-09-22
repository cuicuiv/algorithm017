package 极客大学算法刷题;


class Solution {
	    public int removeDuplicates(int[] nums) {
	      if(nums.length==0) {
	         return 0; //如果数组长度为0 返回0
	      }
	      //设置快慢双指针 用j指针快速扫描 判断
	      int i=0;
	      for(int j=1;j<nums.length;j++){
	    	  //如果nums[j]中的数等于nums[i]中的数则跳过扫描下一个
	    	  //相反则移动i指针 nums[j]覆盖重复的nums[i]
	          if(nums[j]!=nums[i]){ 
	              ++i;
	              nums[i]=nums[j];
	          }
	      }
	      return i+1;

	    }
	}