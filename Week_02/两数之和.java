class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
      for(int i=0;i<nums.length;i++){
           //计算出另一个数
          int a=target-nums[i];
          if(hashtable.containsKey(a)){  //查询在hashtable中是否存在
              return new int[]{hashtable.get(a),i};
          }
          hashtable.put(nums[i],i);//数为键  下标为值
      }
      return new int[0];
    }
}