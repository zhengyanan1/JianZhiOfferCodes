package thirty;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Administrator on 2016/12/30.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class SequenceOfPopPush {
    public boolean IsPopOrder(int [] pushA,int [] popA) {


        /**
         @author zhengyanan
         @date 2016/12/30 @time 15:27
         version_2:
         运行时间：28ms
         占用内存：503k
         相比version_1，判断返回时微微优化了一点
         */
//        Stack<Integer> stack = new Stack<Integer>();
//        for (int i = 0,j=0; i < pushA.length; i++) {
//            stack.push(pushA[i]);
//
//            while (!stack.isEmpty()) {
//                if (stack.peek() == popA[j]) {
//                    stack.pop();
//                    j++;
//                }
//                else {
//                    break;
//                }
//            }
//        }
//
//        return stack.isEmpty();


        /**
           @author zhengyanan
           @date 2016/12/30 @time 15:00
          version_1:
           运行时间：31ms
           占用内存：636k
         思路：假想你在人工做这道题，模拟你人工做题的思路，用代码实现即可：

        */

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0,j=0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty()) {
                if (stack.peek() == popA[j]) {
                    stack.pop();
                    j++;
                }
                else {
                    break;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args){
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{1,2,3,5,4};
        System.out.println(new SequenceOfPopPush().IsPopOrder(push,pop));
    }
}
