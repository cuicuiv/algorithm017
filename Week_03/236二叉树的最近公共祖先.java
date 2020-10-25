class Solution {
    /*
    p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
    p = root ，且 q 在 root的左或右子树中；
    q = root ，且 p 在 root 的左或右子树中；

    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null&&right==null) return null;
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}