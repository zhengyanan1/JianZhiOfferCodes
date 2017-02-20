package ten;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/12/23.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 *
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class LinkedListReverse {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        /**
           @author zhengyanan
           @date 2016/12/23 @time 14:44
          version_1 30ms 503K
        */
        ArrayList<Integer> result = new ArrayList<Integer>();
        ListNode pointer = listNode;
        while (pointer != null){
            result.add(0,pointer.val);
            pointer = pointer.next;
        }

        return result;
    }
    public static void main(String[] args){

    }
}
