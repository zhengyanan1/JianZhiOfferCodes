package twenty;

/**
 * Created by Administrator on 2016/12/28.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoList {
    public ListNode Merge(ListNode list1,ListNode list2) {


        /**
           @author zhengyanan
           @date 2016/12/28 @time 15:25
          version_1
           运行时间：30ms O(m + n)
           占用内存：503k O(1)
         思路：根据定义处理即可：用两个指针指向2个表的头，比较，小的加入result表，并将小的对应指针后移，
           直到其中一个指针指向为空为止；将新表最后一个next指向不为空的那个表即可。
        */
        ListNode newList  = new ListNode(-1) ;
        ListNode head = newList;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                newList.next = list1;

                newList = newList.next;
                list1 = list1.next;
            }
            else {
                newList.next = list2;

                newList = newList.next;
                list2 = list2.next;
            }
        }
        if (list1 == null)  newList.next = list2;
        else                newList.next = list1;

        return head.next;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
