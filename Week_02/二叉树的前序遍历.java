class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList <TreeNode> stack=new LinkedList<>();
        LinkedList <Integer>  output=new LinkedList<>();

        if(root==null){ //当树为空 返回
            return output;
        }

        stack.add(root); //初始将树压入
        while(!stack.isEmpty()){
            TreeNode node=stack.pollLast();
//检索并移除此列表的最后一个元素，或者如果此列表为空，则返回null
            output.add(node.val);

            if(node.right!=null){
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }
        }

  return  output;
     }
}