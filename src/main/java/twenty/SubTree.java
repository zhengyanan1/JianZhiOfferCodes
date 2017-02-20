package twenty;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/13.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class SubTree {

        /**
           @author zhengyanan
           @date 2017/2/13 @time 17:14
          version_2:
            核心思路同1，不同在于：遍历方式的简化，不必像1中先序遍历一遍并用list记忆，完了再遍历，
            直接一次先序遍历，边遍历边处理即可
           运行时间：38ms
           占用内存：629k
        */
        public boolean HasSubtree2(TreeNode root1,TreeNode root2) {
            if (root2 == null || root1 == null)  return false;

            return compareTo(root1,root2)
                    || HasSubtree2(root1.left,root2)
                    || HasSubtree2(root1.right,root2);

        }


    /**
       @author zhengyanan
       @date 2017/2/13 @time 17:04
      version_1:
        核心思路是2步：
            1.将child树跟parent中的某一个树进行比对，即compareTo()函数；
            2.如何遍历取的parent中的每一颗树，调用compareTo()与child树进行比对；
        不足：
            1.没考虑剪枝，直接暴力搜索，采用先序遍历得到的parent中的每一课树
       运行时间：37ms
       占用内存：636k
    */
    private ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null)  return false;
        // @author zyn 16:21 2017/2/13
        // 空树 不是任意一个树的子结构

        initList(root1);

        for (TreeNode treeNode:list){
            if (compareTo(treeNode,root2))  return true;
        }
        return false;

    }
    private boolean compareTo(TreeNode parent,TreeNode child){
        if (child == null)  return true;
        else if (parent == null) return false;
        else{
            if (child.val == parent.val)
                return compareTo(parent.left,child.left) && compareTo(parent.right,child.right);
            else {
                return false;
            }
        }
    }

    private void initList(TreeNode temp){
        if (temp != null) {
            list.add(temp);
            initList(temp.left);
            initList(temp.right);
        }
    }

    public static void main(String[] args){

    }
}
