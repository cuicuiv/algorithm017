package ���ʹ�ѧ�㷨ˢ��;


class Solution {
	    public int removeDuplicates(int[] nums) {
	      if(nums.length==0) {
	         return 0; //������鳤��Ϊ0 ����0
	      }
	      //���ÿ���˫ָ�� ��jָ�����ɨ�� �ж�
	      int i=0;
	      for(int j=1;j<nums.length;j++){
	    	  //���nums[j]�е�������nums[i]�е���������ɨ����һ��
	    	  //�෴���ƶ�iָ�� nums[j]�����ظ���nums[i]
	          if(nums[j]!=nums[i]){ 
	              ++i;
	              nums[i]=nums[j];
	          }
	      }
	      return i+1;

	    }
	}