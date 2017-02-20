package twenty;

/**
 * Created by Administrator on 2016/12/28.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */


public class ReverseList {
    public ListNode ReverseList(ListNode head) {

        /**
           @author zhengyanan
           @date 2016/12/28 @time 11:40
          version_2:
         思路：跟version_1一样，只是处理细节稍有不同，更简洁；
        */
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;

        /**
           @author zhengyanan
           @date 2016/12/28 @time 10:22
           version_1:
           运行时间：32ms O(n)
           占用内存：688k O()
            经典算法：链表原地转置，画图辅助思考，搞清楚关键的循环逻辑如何进行
        */
//        ListNode temp,pointerl,pointerR;
//        temp = head;
//        try {
//            pointerl = temp.next;
//            while (pointerl.next != null){
//                pointerR = pointerl.next;
//                pointerl.next = temp;
//
//                temp = pointerl;
//                pointerl = pointerR;
//            }
//        } catch (Exception e) {
//            /**
//               @author zhengyanan
//               @date 2016/12/28 @time 10:24
//              1:要么是 原链表为null
//             2：要么是原链表只有一个元素
//                这两种情况，都返回head即可
//            */
//            return head;
//        }
//
//
//        pointerl.next = temp;
//        head.next = null;
//        return pointerl;

    }
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
