package sixty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/6.
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class PrintBinaryTreeInZhiStyle {



    /**
       @author zhengyanan
       @date 2017/3/6 @time 16:25
      version_2:
        核心思路：
            1.参考 另一个按行打印二叉树的题，在处理过程中加上标记值：
                生成奇数行时每一行数据往后加；生成偶数行时每一行数据往前加。
       运行时间：34ms
       占用内存：692k
    */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> data = new LinkedList<TreeNode>();

        if (pRoot == null)  return result;
        data.addLast(pRoot);
        boolean isReverse = false;
        while (!data.isEmpty()){
            ArrayList<Integer> oneLine = new ArrayList<Integer>();
            int p = 0,size = data.size();

//            style_1:
            while (p++ < size){
                TreeNode t = data.removeFirst();
                if (isReverse)  oneLine.add(0,t.val);
                else            oneLine.add(t.val);

                if (t.left != null)     data.addLast(t.left);
                if (t.right != null)    data.addLast(t.right);
            }

            isReverse = !isReverse;
            result.add(oneLine);
        }
        return result;
    }

    /**
       @author zhengyanan
       @date 2017/3/6 @time 16:22
      version_1:
        核心思路：
            1.直接参考 另一个按行打印二叉树的题，将其结果中偶数行的数据逆序即可。
    */
//    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        LinkedList<TreeNode> data = new LinkedList<TreeNode>();
//
//        if (pRoot == null)  return result;
//        data.addLast(pRoot);
//        while (!data.isEmpty()){
//            ArrayList<Integer> oneLine = new ArrayList<Integer>();
//            int p = 0,size = data.size();
//
//            while (p++ < size){
//                TreeNode t = data.removeFirst();
//                oneLine.add(t.val);
//                if (t.left != null)     data.addLast(t.left);
//                if (t.right != null)    data.addLast(t.right);
//            }
//
//            result.add(oneLine);
//        }
//
//        for (int i = 0; i < result.size(); i++) {
//            if (i % 2 != 0) Collections.reverse(result.get(i));
//        }
//
//        return result;
//    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);

        t1.left = t2;t1.right = t3;
        t2.left = t4;t2.right = t5;
        t3.left = t6;t3.right = t7;

        System.out.println(
                new PrintBinaryTreeInZhiStyle().Print(t1)
        );
//        ArrayList<Integer> t1 = new ArrayList<Integer>();
//        LinkedList<Integer> t2 = new LinkedList<Integer>();
//        Collections.reverse(t1);
//        Collections.reverse(t2);
    }
}
