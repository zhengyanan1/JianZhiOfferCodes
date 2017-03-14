package sixty;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/7.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
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
public class TheBinaryTreeIsSymmetrical {


    /**
       @author zhengyanan
       @date 2017/3/7 @time 16:11
      version_2:
        核心思路：
            1.version_1吸取的教训：
                1）.应该具体问题具体分析具体对待，而不是被之前做过的题束缚住了手脚；
                2）.遇到一个问题，可以把它转化成另一个好处理的问题，或者是处理过的类似的问题，
                但转化后的问题应该是原问题的充分必要条件，而不仅仅只是必要条件。
            2.根据题意，既然要对称，我们就递归比较左右子树即可。
            3.需要注意的是：如果当前两个子树left 和right值相等，我们就继续递归比较left.left和right.right，
            以及left.right 和right.left（举实例就很容易理解这一点），要保证这2对都对称当前树才对称。
    */
    boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null)  return true;

        return TwoNodeisSymmetrical(pRoot.left,pRoot.right);
    }
    boolean TwoNodeisSymmetrical(TreeNode left,TreeNode right){
        if (left == null)  return right == null;
        else if (right == null)   return false;
        else {
            if (left.val != right.val)  return false;
            else {
                return TwoNodeisSymmetrical(left.left,right.right)
                        && TwoNodeisSymmetrical(left.right,right.left);
            }
        }
    }


    /**
       @author zhengyanan
       @date 2017/3/7 @time 14:59
      version_1:（有问题，已放弃）
        核心思路：
            1.利用逐行打印二叉树那道题的方式，先算出每一行的数据。
            2.因为对称二叉树，所以每一行的数据正着 跟 倒过来 是一样的。
            3.不满足2，就false;都满足，则true;

        PS:（这个思路有问题，如果每个节点的数据都一样怎么办，无法判断此种情况）
    */
//    boolean isSymmetrical(TreeNode pRoot){
//        if (pRoot == null)  return true;
//        LinkedList<TreeNode> data = new LinkedList<TreeNode>();
//        int lineNumber = 0;
//
//        data.addLast(pRoot);
//        while (data.size() != 0){
//            int size = data.size(), i = 0;
//            LinkedList<Integer> oneLine = new LinkedList<Integer>();
//
//            while (i++ < size){
//                TreeNode t = data.removeFirst();
//                oneLine.add(t.val);
//
//                if (t.left != null)     data.addLast(t.left);
//                if (t.right != null)    data.addLast(t.right);
//            }
//            if (lineNumber > 0 && oneLine.size() % 2 != 0)  return false;
//            lineNumber++;
//            if (!reverseIsSame(oneLine))
//                return false;
//        }
//
//        return true;
//    }
    boolean reverseIsSame(LinkedList<Integer> line){
        int i = 0,j = line.size()-1;
        while (i <= j){
            if (!line.get(i++).equals(line.get(j--))) return false;
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(6);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(7);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(5);

        a1.left = a2;a1.right = a3;
        a2.left = a4;a2.right = a5;
        a3.left = a6;a3.right = a7;

        System.out.println(
                new TheBinaryTreeIsSymmetrical().isSymmetrical(a1)
        );
    }
}
