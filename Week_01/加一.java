class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            //������ĩβ ÿ��+1
            digits[i]++;
            digits[i]=digits[i]%10;
            //ѭ���ж��Ƿ�Ϊ0 Ϊ0������ǰ+1  ��Ϊ0�򷵻����� 
            if(digits[i]!=0) return digits;

        }
        //������������� +1ȫ�н�λ ����Ҫ�ֶ��������� ����һλ��λΪ1
        digits=new int [digits.length+1];
        digits[0]=1;
        return digits;
    }
}