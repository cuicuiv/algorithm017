class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        if(root.left==null&&root.right==null){
            return 1;
        }

        int min=Integer.MAX_VALUE;//��ʼ��min�����ֵ Ȼ�󲻶ϸ�������Сֵ
        if(root.left!=null){
            min=Math.min(minDepth(root.left),min);
        }
        if(root.right!=null){
            min=Math.min(minDepth(root.right),min);
        }
        return min+1;
    //������˼ά ������������ʱӦ��ͬʱ�����ҷ�Ϊ����
    }
}

```java
//����
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? 
        left + right + 1: Math.min(left,right) + 1;
        //�����������һ��Ϊ0����ô��С��ȱ�����һ��+1��������Ϊ0��ȫ����Ҷ�ӽڵ㣬��ôȡ��С��ȡ�
       
    }
}