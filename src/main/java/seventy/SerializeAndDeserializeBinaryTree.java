package seventy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/8.
 * 请实现两个函数，分别用来序列化和反序列化二叉树
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
public class SerializeAndDeserializeBinaryTree {




    /**
       @author zhengyanan
       @date 2017/3/9 @time 15:21
      version_1:
        核心思路：
            1.序列化的时候，直接按先序遍历的顺序，取出每个节点的值，并加一个","，追加到String中；
            2.反序列化的时候，先用","将字符串分割成一个字符串数组nodes,
            然后从头开始遍历，遇到"#"，就返回null；
                            否则就生成一个TreeNode root，递归调用设置root.left 和root.right
                            （PS：就是序列化时候的顺序，怎么放进去的，怎么取出来）
    */
    private StringBuilder sb;
    private int index;

    String Serialize(TreeNode root) {
        sb = new StringBuilder("");
        firstIterator(root);
        return sb.toString();
    }

    public void firstIterator(TreeNode root){
        if (root != null){
            sb.append(root.val + ",");
            firstIterator(root.left);
            firstIterator(root.right);
        }
        else{
            sb.append("#,");
        }
    }

    TreeNode Deserialize(String str) {
        index = -1;
        String[] nodes = str.split(",");

        return buildTree(nodes);
    }
    public TreeNode buildTree(String[] nodes){
        index++;
//        if (index >= nodes.length)  return null;
        if (nodes[index].equals("#")){
            return null;
        }
        else {
            TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return root;
        }
    }


    public static void main(String[] args){
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(6);
//        TreeNode a7 = new TreeNode(8);

        a1.left = a2;
        a1.right = a3;

        a2.left = a4;
        a2.right = a5;

        a3.left = a6;
//        a3.right = a7;

        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        String sb = s.Serialize(a1);
        System.out.println(sb);
        s.Deserialize(sb);

    }
}
