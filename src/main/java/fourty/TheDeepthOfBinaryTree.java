package fourty;

/**
 * Created by Administrator on 2017/2/23.
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形
 * 成树的一条路径，最长路径的长度为树的深度。
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
    this.val = val;
    }
 }

public class TheDeepthOfBinaryTree {

    /**
       @author zhengyanan
       @date 2017/2/23 @time 15:02
      verison_2:
        核心思路：
            1.还是先序遍历，不过不用记下当前的深度，直接返回max（左子树深度，右子树深度）+1,
            不断递归调用即可。
            2.相比version_1,代码简洁了很多。
    */
    public int TreeDepth(TreeNode root) {
        if (root == null)   return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }

    /**
       @author zhengyanan
       @date 2017/2/23 @time 14:58
      version_1:
        核心思路：
            1.先序遍历的思路，得到当前的深度count，将count与max比较，用max记忆最大的深度。最大的深度即为所求。
        复杂度：时间O(n)；空间O(1)
       运行时间：30ms
       占用内存：654k
    */
//    private int count = 0;
//    private int max = -1;
//    public int TreeDepth(TreeNode root) {
//        if (root == null)   return 0;
//        traverseNode(root);
//        return max;
//    }
//    private void traverseNode(TreeNode root){
//        count++;
//        max = (count > max ? count : max);
//        if (root.left != null)  {
//            traverseNode(root.left);
//            count--;
//        }
//        if (root.right != null) {
//            traverseNode(root.right);
//            count--;
//        }
//    }
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;

        node5.left = node7;
        System.out.println(new TheDeepthOfBinaryTree().TreeDepth(node1));
    }
}
