class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            //从数组末尾 每次+1
            digits[i]++;
            digits[i]=digits[i]%10;
            //循环判断是否为0 为0继续往前+1  不为0则返回数组 
            if(digits[i]!=0) return digits;

        }
        //如若有特殊情况 +1全有进位 则需要手动创建数组 将第一位进位为1
        digits=new int [digits.length+1];
        digits[0]=1;
        return digits;
    }
}