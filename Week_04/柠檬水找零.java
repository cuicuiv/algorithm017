class Solution {
    public boolean lemonadeChange(int[] bills) {
     int five=0,ten=0;
//�������飬1.�տ���Ԫ��five++ 2.�տ�ʮԪ���ж�����������Ԫ 3.���տ��ʮ ��������Ԫ�Լ�һ��ʮԪһ����Ԫ���һ������
      for(int bill:bills){
          if(bill==5){
              five++;
          }else if(bill==10){
              if(five==0) return false;
              five--;
              ten++;
          }else{
              if(five>0&&ten>0){
                  ten--;
                  five--;
              }else if(five>=3){
                  five-=3;
              }else{
                  return false;
              }
          }

      }
      return
    }
}