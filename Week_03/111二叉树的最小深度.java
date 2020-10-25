class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        if(root.left==null&&root.right==null){
            return 1;
        }

        int min=Integer.MAX_VALUE;//初始将min赋最大值 然后不断更新至最小值
        if(root.left!=null){
            min=Math.min(minDepth(root.left),min);
        }
        if(root.right!=null){
            min=Math.min(minDepth(root.right),min);
        }
        return min+1;
    //用整体思维 考虑左右子树时应该同时将左右分为两块
    }
}

```java
//精简
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? 
        left + right + 1: Math.min(left,right) + 1;
        //当左或者右有一个为0，那么最小深度便是另一方+1，若都不为0即全都有叶子节点，那么取最小深度。
       
    }
}