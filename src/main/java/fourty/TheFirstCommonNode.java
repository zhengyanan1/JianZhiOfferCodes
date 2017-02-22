package fourty;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/2/22.
 * 输入两个链表，找出它们的第一个公共结点。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

}
public class TheFirstCommonNode {

    /**
       @author zhengyanan
       @date 2017/2/22 @time 16:27
      version_2:
       核心思路：
            1.参考了网上的一种处理方式，还是一样的思路，不过不用求长度,具体如下：

            2.假定 List1长度: a+n  List2 长度:b+n, 且 a<b那么 p1 会先到链表尾部,
            这时p2 走到 a+n位置,将p1换成List2头部接着p2 再走b+n-(n+a) =b-a 步到链
            表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
            将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,
            那么p1就是第一个公共节点。或者p1和p2一起走n步到达列表尾部，二者没有公共
            节点，退出循环。 同理a>=b.

       复杂度：输入链表长度为m和n，时间O(m+n)，空间O(1)。
       运行时间：35ms
       占用内存：503k
    */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1,p2 = pHead2;
        while (p1 != p2){
            //style-3
            p1 = (p1 != null ? p1.next:pHead2);
            p2 = (p2 != null ? p2.next:pHead1);

            //style-2
//            if (p1 == null) p1 = pHead2;
//            else            p1 = p1.next;
//            if (p2 == null) p2 = pHead1;
//            else            p2 = p2.next;

            //style-1
//            if (p1 != null) p1 = p1.next;
//            if (p2 != null) p2 = p2.next;
//            if (p1 == null && p2 != null) p1 = pHead2;
//            if (p2 == null && p1 != null) p2 = pHead1;
        }
        return p1;
    }

    /**
       @author zhengyanan
       @date 2017/2/22 @time 15:40
      version_1:
       核心思路：
            1.最简单暴力的思路，就是嵌套循环遍历，找到第一个公共节点，这种显然复杂度是O(n*n)。
            不到万不得已不要用这种方式。我们可以从数据特点出发进行考虑。

            2.假设2个链表有公共节点，那么从这个公共节点起，后面的所有节点都是公共的，
            类似这种效果， 1 -> 2 -> 3 -> 4 -> 5 -> 6
                                        ^
                                   9 -> 0
            所以，如果能从链表的最后一个访问，我们分别从两个链表的最后访问，找到最后一个相等
            节点，即为所求。
            但事实上不能，这是个单向聊表。
            换个思路：
                先求出两个链表的长度len1，len2.算差值add = |len1 - len2|，长的链表先往后遍
                历add个元素，然后再跟短的比较，相等就得到结果；不相等就都往后遍历一个再进行比较。
                这样就去掉了那些无意义的比较（例如上面1和9比较，完全无意义，因为后面链表的长度都
                不等，1 和 9不可能是同一个节点）。

            3.把以上思路写成代码即可
        复杂度：输入链表长度为m和n，时间O(m+n)，空间O(1)。
       运行时间：33ms
       占用内存：688k
    */
//    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        int length1 = 0,length2 = 0;
//        ListNode p1 = pHead1,p2 = pHead2;
//
//        for (;p1 != null;length1++)    p1 = p1.next;
//        for (;p2 != null;length2++)    p2 = p2.next;
//
//        if (length1 == 0 || length2 == 0)   return null;
//        else if (length1 >= length2){
//            int add = length1 - length2;
//            while (add > 0){
//                pHead1 = pHead1.next;
//                add--;
//            }
//        }
//        else{
//            int add = length2 - length1;
//            while (add > 0){
//                pHead2 = pHead2.next;
//                add--;
//            }
//        }
//        while (pHead1!=pHead2){
//            pHead1 = pHead1.next;
//            pHead2 = pHead2.next;
//        }
//
//        return pHead1;
//    }
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node4;
        node4.next = node5;
        node5.next = node6;
        node3.next =node4;

        System.out.println(new TheFirstCommonNode().FindFirstCommonNode(node1,node3).val);
    }
}
