package sixty;

import org.omg.CORBA.INTERNAL;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ASUS on 2017/3/5.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}
public class DeleteRepeatedNodes {



    /**
    @author zhengyanan
    @time 21:52
    @description
     version_3:
    核心思路：
        1.先给原链表添加一个头结点方便处理；
        2.使用3个指针，一个指向前一个节点last，一个指向当前节点p，一个指向下一个节点p->next。
        3.当当前节点跟后一个节点相等时，不断往后遍历，找到第一个不等于当前节点的节点；然后用
        last 指向它；当当前节点跟后一个不相等时，将last 后移指向p，p后移一位
     */
    public ListNode deleteDuplication(ListNode pHead){
        ListNode first = new ListNode(Integer.MIN_VALUE),last;
        first.next = pHead;
        last = first;
        while (pHead != null && pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                int val = pHead.val;
                while (pHead!= null && pHead.val == val) pHead = pHead.next;
                last.next = pHead;
            }
            else {
                last = pHead;
                pHead = pHead.next;
            }
        }

        return first.next;
    }


    /**
    @author zhengyanan
    @time 21:33
    @description
        version_2:
    核心思路：
        1.基本同version_1，不过借用了容器类，简洁了代码。
    运行时间：33ms
    占用内存：629k
     */
//    public ListNode deleteDuplication(ListNode pHead){
//        LinkedList<ListNode> result = new LinkedList<ListNode>();
//        result.addLast(new ListNode(Integer.MIN_VALUE));
//        boolean isRepeated = false;
//        while (pHead != null){
//            if (result.getLast().val == pHead.val){
//               isRepeated = true;
//            }
//            else {
//                if (isRepeated){
//                    result.removeLast();
//                    isRepeated = false;
//                }
//                result.addLast(pHead);
//            }
//            pHead = pHead.next;
//        }
//        if (isRepeated) result.removeLast();
//
//        if (result.size() == 1) return null;
//
//        for (int i = 0; i < result.size() - 1; i++) {
//            result.get(i).next = result.get(i+1);
//        }
//        result.get(result.size() - 1).next = null;
//
//        return result.get(0).next;
//    }

    /**
    @author zhengyanan
    @time 21:10
    @description
        version_1:
            核心思路：
                1.先给原链表添加一个头结点；
                2.循环一遍，每当访问当前节点时，判断其后紧跟的几个是否跟它相等，相等就删除，
                并把当前访问节点的值标记为MAX；
                3.在循环一遍，去掉值为MAX的；
                4.返回头结点的next即可。
     */
//    public ListNode deleteDuplication(ListNode pHead){
//        ListNode tHead = new ListNode(Integer.MIN_VALUE),t;
//        boolean isRepeated;
//        tHead.next = pHead;
//
//        pHead = tHead;
//        while (pHead != null){
//            isRepeated = false;
//
//            t = pHead.next;
//            if (t == null)  break;
//
//            while (t.val == pHead.val){
//                isRepeated = true;
//                t = t.next;
//                if (t == null){
//                    pHead.next = null;
//                    break;
//                }
//            }
//
//            pHead.next  = t;
//            if (isRepeated) pHead.val = Integer.MAX_VALUE;
//            pHead = pHead.next;
//        }
//
//        pHead = tHead;
//        while (pHead != null){
//            if (pHead.next == null) break;
//            else if (pHead.next.val == Integer.MAX_VALUE){
//                pHead.next = pHead.next.next;
//            }else {
//                pHead = pHead.next;
//            }
//        }
//
//        return tHead.next;
//    }

    public static void main(String[] args){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(3);
        ListNode a5 = new ListNode(4);
        ListNode a6 = new ListNode(4);
        ListNode a7 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;


        ListNode t = new DeleteRepeatedNodes().deleteDuplication(a1);

        while (t != null){
            System.out.println(t.val);
            t = t.next;
        }
    }
}
