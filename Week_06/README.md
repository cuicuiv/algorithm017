**动态规划**
>动态规划和递归或分治没有根本上的区别
>共性：找到重复子问题
>差异性：最优子结构，中途可以淘汰次优解
>步骤：
>①分解问题
>②状态转移方程的推导
>③合并子问题
>④dp表的递推

[最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/submissions/)
>![在这里插入图片描述](https://img-blog.csdnimg.cn/2020110522215185.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0xjdWljdWk=,size_16,color_FFFFFF,t_70#pic_center)

```java
/*状态转移方程
if(s1.charAt(i)==s2.charAr(j))
            dp[i][j]=dp[i-1][j-1]+1;
        else
            dp[i][j]=Math.max(dp[i -1][j],dp[i][j -1]);
            */
            class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
         int m=text1.length(),n=text2.length();
         int[][] dp=new int[m+1][n+1];
         for(int i=1;i<m+1;i++){
             for(int j=1;j<n+1;j++){
                 char c1=text1.charAt(i-1),c2=text2.charAt(j-1);
                 if(c1==c2){
                     dp[i][j]=dp[i-1][j-1]+1;
                 }else{
                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                 }
             }
         }
        return dp[m][n];
    }
}
```

[不同路径](https://leetcode-cn.com/problems/unique-paths/submissions/)
```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int [m+1][n+1];
        //因为下一步只能往下或者右 所以当前步由上一行或者上一列而来
        for(int i=1;i<m+1;i++) dp[i][1]=1; 
        //初始化第一行和第一列为1 因为往右或者往下只有一种方法
        for(int j=1;j<n+1;j++) dp[1][j]=1;
        for(int i=2;i<m+1;i++){
            for(int j=2;j<n+1;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];

       
    }
}
```
[不同路径ll](https://leetcode-cn.com/problems/unique-paths-ii/)

```java
class Solution {
//与上面不同的是多了障碍物
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        //初始化第一列 如果有障碍 则第一列后面都无法走到
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]==1){break;}
            dp[i][0]=1;
        }
        //初始化第一行 同上
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]==1){break;}
            dp[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=obstacleGrid[i][j]==1?0:dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
```


[三角形最小路径和](https://leetcode-cn.com/problems/triangle/)
```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n+1][n+1];//二维数组最后一行为空
        //从三角形的最后一行开始递推
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
                //dp[i][j] 表示从点(i,j) 到底边的最小路径和
                
            }
        }
        return dp[0][0];
    }
}
时间复杂度：O(N^2^)，N为三角形的行数。
空间复杂度：O(N^2^)，N 为三角形的行数。

​```java

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }   
}
时间复杂度：O(N^2^)，N为三角形的行数。
空间复杂度：O(N)，N 为三角形的行数。
```
[最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
```java
//该题是不同路径的引申
//分三种情况考虑 1.i=0(往下走)
			//	2.j=0(往右走)
			//  3、dp[i][j]=dp[i][j-1]+dp[i-1][j]
class Solution {
    public int minPathSum(int[][] grid) {
        //分解问题      下一步由上或者左移动而来
        //dp方程推导    dp[i][j]=dp[i][j-1]+dp[i-1][j]
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) continue;
                else if(i==0) grid[i][j]=grid[i][j-1]+grid[i][j];
                else if(j==0) grid[i][j]=grid[i-1][j]+grid[i][j];
                else grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[m-1][n-1];

    }
}
```
 [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/submissions/)
```java
class Solution {
    public int climbStairs(int n) {
        if(n==0||n==1||n==2){
            return n;
        }
        //注意数组越界
        int[] a=new int[n+1];
        a[1]=1;
        a[2]=2;
        for(int i=3;i<n+1;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n];
    }
}

class Solution {
    public int climbStairs(int n) {
        int p=0,q=0,r=1;
        for(int i=0;i<n;i++){
            p=q;
            q=r;
            r=p+q;
        }
        return r;

    }
}
```

