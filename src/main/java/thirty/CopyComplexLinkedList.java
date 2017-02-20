package thirty;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/2/15.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class CopyComplexLinkedList {


    /**
       @author zhengyanan
       @date 2017/2/16 @time 10:20
      version_2:
        核心思路:
            三步法：
            1.复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
            2.遍历链表，A1->random = A->random->next;
            3.将链表拆分成原链表和复制后的链表
        时间：O(n);空间：O(n)
       运行时间：32ms
       占用内存：692k
    */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)  return null;

        RandomListNode pointer = pHead;
        RandomListNode pResult,pCurrent;

        while (pointer != null){//1
            RandomListNode pCloned = new RandomListNode(pointer.label);
            pCloned.next = pointer.next;
            pointer.next = pCloned;

            pointer = pCloned.next;
        }

        pointer = pHead;//2
        while (pointer!= null){
            pointer.next.random = (pointer.random == null ? null:pointer.random.next);
            pointer = pointer.next.next;
        }

        pointer = pHead;//3,一次循环遍历2个元素
        pCurrent = pResult = pointer.next;
        while (pCurrent.next != null){
            pointer.next = pCurrent.next;
            pCurrent.next = pointer.next.next;

            pointer = pointer.next;
            pCurrent = pCurrent.next;
        }
        pointer.next = null;

        return pResult;
    }


    /**
       @author zhengyanan
       @date 2017/2/15 @time 21:38
        version_1:
        核心思路：
            1.先用2个list分别筛出原链表的next结点 和random结点
            2.2层循环确定出random结点对应于next中的结点位置。
            3.复制拷贝
       运行时间：37ms    O(n*n)
       占用内存：692k    O(n)
    */
    /**
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)  return null;
        RandomListNode t = pHead;
        LinkedList<RandomListNode> nextNodes = new LinkedList<RandomListNode>();
        LinkedList<RandomListNode> randomNodes = new LinkedList<RandomListNode>();
        LinkedList<RandomListNode> resultsNodes = new LinkedList<RandomListNode>();
        int[] random;

        nextNodes.add(t);
        while (t != null){
            nextNodes.add(t.next);
            randomNodes.add(t.random);
            t = t.next;
        }
        nextNodes.removeLast();//remove 多加的 null

        random = new int[randomNodes.size()];
        Arrays.fill(random,-1);
        for (int i = 0; i < randomNodes.size(); i++) {
            for (int j = 0; j < nextNodes.size(); j++) {
                if (randomNodes.get(i) == nextNodes.get(j)){
                    random[i] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < nextNodes.size(); i++) {
            resultsNodes.add(new RandomListNode(nextNodes.get(i).label));
        }
        for (int i = 0; i < nextNodes.size() - 1; i++) {
            resultsNodes.get(i).next = resultsNodes.get(i + 1);

            if (random[i] == -1)    resultsNodes.get(i).random = null;
            else                    resultsNodes.get(i).random = resultsNodes.get(random[i]);
        }

        resultsNodes.get(nextNodes.size() - 1).random =
                (random[random.length - 1] == -1 ? null:resultsNodes.get(random[random.length - 1]));

        return resultsNodes.get(0);


//        {
//            RandomListNode test = new RandomListNode(nextNodes.size());
//            test.next = new RandomListNode(randomNodes.size());
//            test.random = test.next;
//            test.next.random = test.next;
//            return test;
//        }
//        For Test：
    }  */

    public static void main(String[] args){
        LinkedList<RandomListNode> list = new LinkedList<RandomListNode>();
        for (int i = 1; i < 6; i++) {
            list.add(new RandomListNode(i));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i+1);
        }
        list.get(0).random = list.get(2);
        list.get(1).random = list.get(4);
        list.get(2).random = null;
        list.get(3).random = list.get(1);
        list.get(4).random = null;

        RandomListNode r =
            new CopyComplexLinkedList().Clone(list.get(0));
        while (r != null){
            System.out.print("CopyComplexLinkedList.main():" + r.label +";");
            System.out.println((r.random == null? null:r.random.label));
            r = r.next;
        }
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        list.add(null);
//        list.add(null);
//        System.out.println("CopyComplexLinkedList.main():" + list.size());
    }
}
