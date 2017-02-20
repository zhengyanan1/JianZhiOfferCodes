package thirty;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by ASUS on 2017/2/13.
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 */
//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//
//}
public class PrintBinaryTreeTopToBottom {


    /**
    @author zhengyanan
    @time 20:36
    @description
     核心思路:二叉树的广度优先搜索，借助一个队列即可
    运行时间：35ms
    占用内存：629k

    */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        LinkedList<TreeNode> pools = new LinkedList<TreeNode>();

        if (root != null)   pools.addLast(root);

        while (!pools.isEmpty()){
            TreeNode t = pools.removeFirst();

            results.add(t.val);
            if (t.left != null)     pools.addLast(t.left);
            if (t.right != null)    pools.addLast(t.right);
        }
        return results;
    }
}
