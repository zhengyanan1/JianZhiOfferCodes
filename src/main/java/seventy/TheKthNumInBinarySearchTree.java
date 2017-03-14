package seventy;

/**
 * Created by Administrator on 2017/3/8.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class TheKthNumInBinarySearchTree {




    /**
       @author zhengyanan
       @date 2017/3/8 @time 10:31
      version_1:
        核心思路：
            1.直接中序遍历，边遍历边计数，直到找到目标值为止，此时设置标记值结束递归即可。
        复杂度：时间O(n),空间O(1)
    */
    private int count = 0,target;
    private boolean isFinish = false;
    private TreeNode result;
    TreeNode KthNode(TreeNode pRoot, int k) {
        target = k;
        infix(pRoot);

        return result;
    }
    public void infix(TreeNode root){
        if (isFinish)   return;
        if (root != null){
            infix(root.left);

            count++;
            System.out.println(root.val);
            if (count == target){
                result = root;
                isFinish = true;
                return;
            }

            infix(root.right);
        }
    }
    public static void main(String[] args){
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(8);

        a1.left = a2;a1.right = a3;
        a2.left = a4;a2.right = a5;
        a3.left = a6;a3.right = a7;

        new TheKthNumInBinarySearchTree().KthNode(a1,3);
    }
}
