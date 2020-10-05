class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
      for(int i=0;i<nums.length;i++){
           //�������һ����
          int a=target-nums[i];
          if(hashtable.containsKey(a)){  //��ѯ��hashtable���Ƿ����
              return new int[]{hashtable.get(a),i};
          }
          hashtable.put(nums[i],i);//��Ϊ��  �±�Ϊֵ
      }
      return new int[0];
    }
}