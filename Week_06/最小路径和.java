//�����ǲ�ͬ·��������
//������������� 1.i=0(������)
			//	2.j=0(������)
			//  3��dp[i][j]=dp[i][j-1]+dp[i-1][j]
class Solution {
    public int minPathSum(int[][] grid) {
        //�ֽ�����      ��һ�����ϻ������ƶ�����
        //dp�����Ƶ�    dp[i][j]=dp[i][j-1]+dp[i-1][j]
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