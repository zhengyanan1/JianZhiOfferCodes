package sixty;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Administrator on 2017/3/3.
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        super();
        this.val = val;
    }
}
public class TheEntryOfLoopForLinkedList {

    /**
       @author zhengyanan
       @date 2017/3/3 @time 17:04
       version_1:
        核心思路：
        1.使用HashSet，遍历链表，不断地把Node往set里加，每次加之前判断是否已经包含此node：
            如果包含，此node即为所求；
            否则；继续循环
       运行时间：38ms
       占用内存：654k
    */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> nodes = new HashSet<ListNode>();
        ListNode p = pHead;
        while (p !=  null){
            if (nodes.contains(p))  return p;

            nodes.add(p);
            p = p.next;
        }

        return null;
    }
}
