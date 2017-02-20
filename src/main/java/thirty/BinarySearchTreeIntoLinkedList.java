package thirty;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/2/16.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
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
public class BinarySearchTreeIntoLinkedList {



    /**
       @author zhengyanan
       @date 2017/2/16 @time 20:31
       version_2:
       核心思路：
            1.基本同version_1,还是中序遍历，不过没有用到容器，在遍历的过程中直接加上了left 和right。
            更简洁。
       复杂度： 时间 O(n); 空间 O(1)
       运行时间：32ms
       占用内存：503k
    */
    private TreeNode head = null,current = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        iteratorTree(pRootOfTree);
        return head;
    }
    private void iteratorTree(TreeNode root){
        if (root != null) {
            iteratorTree(root.left);
            if (head == null){
                head = root;
                current = head;
            }else {
                current.right = root;
                root.left = current;

                current = root;
            }
            iteratorTree(root.right);
        }
    }


    /**
       @author zhengyanan
       @date 2017/2/16 @time 20:06
       version_1:
        核心思路：
            1.根据其特性，二叉搜索树，采用中序遍历的方式，遍历一遍，并用一个容器记忆下来
            2.遍历2遍容器，分别给其添加left 和right。
            3.返回第一个元素即可。
        复杂度： 时间 O(n) 空间O(1)
       运行时间：30ms
       占用内存：528k
    */
    /**
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)    return null;

        iteratorTree(pRootOfTree);

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
        }
//        list.get(list.size() - 1).right = null;
        //这句可以不要，因为其肯定为null

        for (int i = 1; i < list.size() ; i++) {
            list.get(i).left = list.get(i - 1);
        }
//        list.get(0).left = null;
        //这句可以不要，因为其肯定为null

        return list.get(0);
    }
    private void iteratorTree(TreeNode root){
        if (root != null) {
            iteratorTree(root.left);
            list.add(root);
            iteratorTree(root.right);
        }
    }
     */
}
