class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList <TreeNode> stack=new LinkedList<>();
        LinkedList <Integer>  output=new LinkedList<>();

        if(root==null){ //����Ϊ�� ����
            return output;
        }

        stack.add(root); //��ʼ����ѹ��
        while(!stack.isEmpty()){
            TreeNode node=stack.pollLast();
//�������Ƴ����б�����һ��Ԫ�أ�����������б�Ϊ�գ��򷵻�null
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