package sixty;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/6.
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class PrintBinaryTreeInMultiLines {

    /**
       @author zhengyanan
       @date 2017/3/6 @time 15:50
      version_2:
        核心思路：
            1.基本思路同version_1,不过以一种很巧妙的方式区分了每一行。
            2.先将pRoot加入队列，此时队列的size即为第一行；
                1）.从队列中移除size个节点（边移除边加入其left和right），这些即为第一行的数据；
                完毕后，第一行的结点被全部移除，第二行的结点被全部加入；
                2）.再计算size，这些即为第二行的数据个数；再从队列中移除size个节点...
                3）.以此类推，即可得到结果集。
       复杂度：时间O(n)；空间O(n)
       运行时间：35ms
       占用内存：692k

    */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> data = new LinkedList<TreeNode>();

        if (pRoot == null)  return result;
        data.addLast(pRoot);
        while (!data.isEmpty()){
            ArrayList<Integer> oneLine = new ArrayList<Integer>();
            int p = 0,size = data.size();

            while (p++ < size){
                TreeNode t = data.removeFirst();
                oneLine.add(t.val);
                if (t.left != null)     data.addLast(t.left);
                if (t.right != null)    data.addLast(t.right);
            }

            result.add(oneLine);
        }

        return result;
    }

    /**
       @author zhengyanan
       @date 2017/3/6 @time 15:19
      version_1:
        核心思路：
            1.类比从上到下从左到右打印二叉树，这里需要你做的再多一点：每一行需要标记一下。
            2.我们还是用先进先出队列来实现：
                1）如果pRoot == null ，直接返回；
                2）否则：向队列加入pRoot 和null(用于标记每一行)。
            3.不断的从队列中取出数据t：
                1）.如果t ！= null,就把t.val加入当前行的数据中，把t的left 和right加入。
                2）.如果t == null,说明一行已经完了，将oneLine加入结果集，将null加入队列标记下一行。
            4.需要注意的是：在3中 t == null里 加上循环退出条件。
       复杂度：时间O(n)；空间O(n)
       运行时间：38ms
       占用内存：692k
    */
//    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        LinkedList<TreeNode> data = new LinkedList<TreeNode>();
//        ArrayList<Integer> oneLine = new ArrayList<Integer>();
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//        if (pRoot == null)  return result;
//        TreeNode t ;
//        data.addLast(pRoot);
//        data.addLast(null);
//
//        while (!data.isEmpty()){
//            t = data.removeFirst();
//            if (t != null){
//                oneLine.add(t.val);
//                if (t.left != null)     data.addLast(t.left);
//                if (t.right != null)    data.addLast(t.right);
//            }
//            else {
//                result.add(oneLine);
//                if (data.isEmpty()) break;
//
//                oneLine = new ArrayList<Integer>();
//                data.addLast(null);
//            }
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

        long start = System.currentTimeMillis();
        System.out.println(
        new PrintBinaryTreeInMultiLines().Print(t1)
        );
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
