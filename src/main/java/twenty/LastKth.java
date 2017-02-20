package twenty;

/**
 * Created by Administrator on 2016/12/27.
 * 输入一个链表，输出该链表中倒数第k个结点。
 */


public class LastKth {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {


        /**
           @author zhengyanan
           @date 2016/12/27 @time 12:04
           运行时间：32ms O(n)
           占用内存：688k O(1)
         思路：用2个指针，一个先跑k-1步,使2者相差k-1步。然后再一起跑，当后者跑到终点时，前者正好就是倒数第k个数
            这样就只用遍历一遍链表
        */
        if (k <= 0) return null;
        ListNode left = head, right = head;
        int count = 1;
        try {
            while (count < k){
                right = right.next;
                count++;
            }

            while (right.next != null){
                left = left.next;
                right = right.next;
            }
        } catch (NullPointerException e) {
            return null;
        }

        return left;

        /**
           @author zhengyanan
           @date 2016/12/27 @time 11:10
          version_1:
            思路：先循环一遍，算出list的长度，把倒数转为正数第几个
            再循环一遍，找到即可
           运行时间：38ms O(n)
           占用内存：629k O(1)
        */
//        int count = 0;
//        ListNode pointer = head;
//        while (pointer != null){
//            count ++;
//            pointer = pointer.next;
//        }
//        count = count - k + 1;
//        if (count <= 0) return null;
//        pointer = head;
//        while (count > 1){
//            pointer = pointer.next;
//            count--;
//        }
//        return pointer;
    }
    public static void main(String[] args){

    }
}
