package thirty;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/2/15.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
 }

public class BinaryTreePathSum {
    /**
       @author zhengyanan
       @date 2017/2/15 @time 11:16
       version_2:
        核心思路：相比version_1,改进之处在于，始终用一个sum记住当前list中节点和，加入节点就+value;
            pop节点就-value，不必每次访问到叶子节点都遍历整个节点list进行求和比较。
            除此之外，其他同verison_1。
       运行时间：36ms
       占用内存：533k
    */
    private boolean isNull = false;
    private LinkedList<Integer> nodesVal = new LinkedList<Integer>();
    private ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    private int total;
    private int sum = 0;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        total = target;

        FirstTraverseTree(root);

        return paths;
    }

    public void FirstTraverseTree(TreeNode root){
        if (null == root)   {
            isNull = true;
            return;
        }

        nodesVal.addLast(root.val);
        sum += root.val;

        if (root.left == null && root.right == null){
            if (sum == total){
                paths.add(new ArrayList<Integer>(nodesVal));
            }
        }
        else {
            FirstTraverseTree(root.left);
            if (!isNull) {
                sum -= nodesVal.removeLast();
                isNull = false;
            }
            FirstTraverseTree(root.right);
            if (!isNull) {
                sum -= nodesVal.removeLast();
                isNull = false;
            }
        }
    }

    /**
       @author zhengyanan
       @date 2017/2/15 @time 10:46
        version_1:
        核心思路：
            1.采用先序遍历的方式，遍历二叉树，并往里加入节点list
            2.当访问到叶子节点时，计算路径和，从而决定是否要加入新路径；
            3.访问完左子树，一定要从节点list中压出左子树；访问完右子树，也一定要从节点list压出右子树。
        以此来确保节点list里始终都是一条新路径。（当访问的子树为空时，不能压出，因为为空时没有压入）
       运行时间：33ms
       占用内存：659k
    */
//    private boolean isNull = false;
//    private LinkedList<Integer> nodesVal = new LinkedList<Integer>();
//    private ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
//    private int total;
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//        total = target;
//
//        FirstTraverseTree(root);
//
//        return paths;
//    }
//
//    public void FirstTraverseTree(TreeNode root){
//        if (null == root)   {
//            isNull = true;
//            return;
//        }
//
//        nodesVal.addLast(root.val);
//        if (root.left == null && root.right == null){
//            int sum = 0;
//            for (Integer nodeVal : nodesVal){
//                sum += nodeVal;
//            }
//            if (sum == total){
//                paths.add(new ArrayList<Integer>(nodesVal));
//            }
//        }
//        else {
//            FirstTraverseTree(root.left);
//            if (!isNull) {
//                nodesVal.removeLast();
//                isNull = false;
//            }
//            FirstTraverseTree(root.right);
//            if (!isNull) {
//                nodesVal.removeLast();
//                isNull = false;
//            }
//        }
//    }
}


















