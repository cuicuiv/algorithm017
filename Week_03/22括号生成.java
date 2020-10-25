class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        dfs(res, n, n, "");
        return res;
    }

    private void dfs(List<String> res, int left, int right, String curStr) {
        if (left == 0 && right == 0) { // �������Ŷ���ʣ���ˣ�˵���ҵ�����Ч������
            res.add(curStr);
            return;
        }
        //������ֻ��ʣ���ʱ��ſ���ѡ����������ŵ������Ѿ�ѡ���ˣ��ǲ�����ѡ�������ˡ�
        //���ѡ���������������ǻ�����ѡ�������ŵġ�
        if (left < 0)
            return;
        // ���������ʣ������С��������ʣ���������˵��֮ǰѡ�����Ч
        if (right < left)
            return;
        //ѡ��������
        dfs(res, left - 1, right, curStr + "(");
        //ѡ��������
        dfs(res, left, right - 1, curStr + ")");
    }

    
}