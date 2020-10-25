>快速幂原理：
>偶次幂：2^10^ =2^5^*2^5^=2^5+5^
>奇次幂：2^11^=2^5^*2^5^x2=2^5+5+1^
```java
class Solution {
    public double myPow(double x, int n) {
     long N=n;
     //n存在正或负两种情况
     return N>=0?quick(x,N):1.0/quick(x,-N);
    }
    double quick(double x,long N){
        if(N==0){
            return 1.0;
        }
        double y=quick(x,N/2);
        //次方存在偶数奇数两种情况
        return N%2==0?y*y:y*y*x;
    }
}