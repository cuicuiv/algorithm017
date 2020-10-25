class Solution {
    public boolean lemonadeChange(int[] bills) {
     int five=0,ten=0;
//遍历数组，1.收款五元，five++ 2.收款十元，判断手上有无五元 3.当收款二十 有三张五元以及一张十元一张五元的找回情况。
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