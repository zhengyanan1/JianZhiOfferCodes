package twenty;

/**
 * Created by Administrator on 2017/2/13.
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 输入描述:
 二叉树的镜像定义：源二叉树
 8
 /  \
 6   10
 / \  / \
 5  7 9 11
 镜像二叉树
 8
 /  \
 10   6
 / \  / \
 11 9 7  5
 *
 */
//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//
//    }
//
//}
public class MirrorBinaryTree {





    /**
       @author zhengyanan
       @date 2017/2/13 @time 17:48
      version_1:
            核心思路：以先序遍历的方式递归每个节点，exchange每个节点的两个child节点的位置

       运行时间：36ms
       占用内存：688k
    */
    public void Mirror(TreeNode root) {
        exchangeChild(root);
    }
    private void exchangeChild(TreeNode parent){
        if (parent == null) return;
        else {
            if (parent.left != null || parent.right != null){
                TreeNode temp;
                temp = parent.left;
                parent.left = parent.right;
                parent.right = temp;

                exchangeChild(parent.left);
                exchangeChild(parent.right);
            }
        }
    }
}
