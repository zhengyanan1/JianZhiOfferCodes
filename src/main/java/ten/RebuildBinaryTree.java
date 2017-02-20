package ten;

/**
 * Created by ASUS on 2017/1/25.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class RebuildBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reBuildBinaryTree(pre,0,pre.length-1,
                                in,0,in.length-1);
    }



    /**
    @author zhengyanan
    @time 0:55
    @description
    version_1
     思路：递归,理清楚边界条件即可
     */
    private TreeNode reBuildBinaryTree(int[] pre,int pre_Start, int pre_End,
                                       int[] in,int in_Start,int in_End){
        if (pre_Start > pre_End)   return null;

        TreeNode root = new TreeNode(pre[pre_Start]);
        if (pre_End == pre_Start)    return root;

        int root_index = 0;
        for (int i = in_Start; i <= in_End; i++) {
            if (in[i] == pre[pre_Start]){
                root_index = i;
                break;
            }
        }
        root.left = reBuildBinaryTree(
                pre,pre_Start+1,pre_Start+root_index-in_Start,
                in,in_Start,root_index-1);
        root.right = reBuildBinaryTree(
                pre,pre_Start+root_index-in_Start+1,pre_End,
                in,root_index+1,in_End);
        return root;
    }

    /**
    @author zhengyanan
    @time 0:56
    @description
    此为残次品，每次生成新数组，效率太低
     */
//    public ten.TreeNode reBuildBinaryTree(List<Integer> pre,List<Integer> in){
//        if (pre.size() == 0)    return null;
//
//        ten.TreeNode root = new ten.TreeNode(pre.get(0));
//        if (pre.size() == 1)    return root;
//
//        ArrayList<Integer> leftpre = new ArrayList<Integer>();
//        ArrayList<Integer> leftin = new ArrayList<Integer>();
//        ArrayList<Integer> rightpre = new ArrayList<Integer>();
//        ArrayList<Integer> rightin = new ArrayList<Integer>();
//
//        int key = in.size();
//        for (int i = 0; i < in.size(); i++) {
//            if (in.get(i) == pre.get(0)){
//                key = i;
//                continue;
//            }
//            if (i < key){
//                leftin.add(in.get(i));
//            }
//            else {
//                rightin.add(in.get(i));
//            }
//        }
//
//        for (int i = 1,j=0; i < pre.size(); i++) {
//            if (j == leftin.size()){
//                rightpre.add(pre.get(i));
//            }
//            else {
//                leftpre.add(pre.get(i));
//                j++;
//            }
//        }
//        root.left = this.reBuildBinaryTree(leftpre,leftin);
//        root.right = this.reBuildBinaryTree(rightpre,rightin);
//        return root;
//    }
    public static void main(String[] args){
        TreeNode root =
                new RebuildBinaryTree().reConstructBinaryTree(
                        new int[]{1,2,4,3,5,6},
                        new int[]{4,2,1,5,3,6}
                );
        showBinaryTree(root);

    }

    static void showBinaryTree(TreeNode root){
        if (root !=null) {
            showBinaryTree(root.left);
            System.out.println(root.val);
            showBinaryTree(root.right);
        }
    }
}
