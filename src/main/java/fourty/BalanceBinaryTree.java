package fourty;

/**
 * Created by Administrator on 2017/2/24.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
/**
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
 */
public class BalanceBinaryTree {


    /**
       @author zhengyanan
       @date 2017/2/24 @time 15:47
        version_2:
        核心思路：
            1.根据verison_1中的优化思路来，采用后序遍历的方式求高度，（左，右，根），由于在访问根节点
            之前就已经算好了left和right的，就可以顺便比较left和right，判断是否为平衡树。这样每个节点
            只需访问一次。
        复杂度：时间O(n)；空间O(1)
       运行时间：35ms
       占用内存：503k
     */
    private boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        lengthOfTree(root);
        return isBalance;
    }
    private int lengthOfTree(TreeNode root){
        if (root == null)   return 0;

        int left ,right;
        left = lengthOfTree(root.left);
        right = lengthOfTree(root.right);
        if (Math.abs(left - right) > 1) isBalance = false;

        return (right > left ? right:left)+1;
    }

    /**
       @author zhengyanan
       @date 2017/2/24 @time 15:28
      verisn_1:
        核心思想：
            1.根据定义来，先保证root树（左右子树高度差不超过1），再保证root.left,root.right也满足这一点
            2.按上述思想，先写一个求数高度的函数，然后进行递归调用即可。
        不足：
            1.此种思路是根据定义自顶向下进行判断的，靠下的结点在计算树高度时被访问过多次；
            如果能换一种自下往上的方式来，那样效率应该会高一些。
       复杂度：时间>O(n),空间O(1)
       运行时间：39ms
       占用内存：528k
    */
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if(null == root)    return true;
//        if (Math.abs(lengthOfTree(root.left) - lengthOfTree(root.right)) <= 1) {
//            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//        }
//        else {
//            return false;
//        }
//
//    }
//    private int lengthOfTree(TreeNode root){
//        if (root == null)   return 0;
//
//        return Math.max(lengthOfTree(root.left),lengthOfTree(root.right))+1;
//    }
}
