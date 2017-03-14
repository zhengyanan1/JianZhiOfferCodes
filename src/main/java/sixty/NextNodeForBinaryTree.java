package sixty;

import java.util.LinkedList;

/**
 * Created by ASUS on 2017/3/6.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NextNodeForBinaryTree {
    /**
       @author zhengyanan
       @date 2017/3/7 @time 11:58
      version_2:
        核心思路：
            1.判断当前节点是否有右子树，有的话，就输出右子树中序遍历的第一个节点
            2.如果没有右子树：
                就看当前节点是否是其父节点p的左子树：
                    是就输出父节点；
                    否则就判断p是否p.next的左子树，
                        是就输出p.next；
                        否则就判断p.next是否是p.next.next的左子树
                        。。。。。。
            3.如果1,2都找不到，返回null
    */
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null)  return null;
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        else{
            while (pNode.next != null){
                if (pNode == pNode.next.left)   return pNode.next;
                else pNode = pNode.next;
            }
        }

        return null;
    }

    /**
       @author zhengyanan
       @date 2017/3/7 @time 11:26
      version_1:
        核心思路：
            1.直接找到根节点，中序遍历并把节点存储到链表中；
            2.遍历链表，找到目标节点的下一个节点输出即可。
    */
//    LinkedList<TreeLinkNode> infixData = new LinkedList<TreeLinkNode>();
//    public TreeLinkNode GetNext(TreeLinkNode pNode){
//        TreeLinkNode root = pNode;
//        while (root.next != null)   root = root.next;
//        infixIterator(root);
//
//        int i;
//        for (i = 0; i < infixData.size(); i++)
//            if (infixData.get(i) == pNode)  break;
//        return i+1 < infixData.size()?infixData.get(i+1):null;
//    }
//    public void infixIterator(TreeLinkNode root){
//        if (root != null){
//            infixIterator(root.left);
//            infixData.add(root);
//            infixIterator(root.right);
//        }
//    }
    public static void main(String[] args){
        TreeLinkNode a1 = new TreeLinkNode(8);
        TreeLinkNode a2 = new TreeLinkNode(6);
        TreeLinkNode a3 = new TreeLinkNode(10);
        TreeLinkNode a4 = new TreeLinkNode(5);
        TreeLinkNode a5 = new TreeLinkNode(7);
        TreeLinkNode a6 = new TreeLinkNode(9);
        TreeLinkNode a7 = new TreeLinkNode(11);

        a1.left = a2;a1.right = a3;
        a2.left = a4;a2.right = a5;
        a3.left = a6;a3.right = a7;

        new NextNodeForBinaryTree().GetNext(a4);
    }
}









