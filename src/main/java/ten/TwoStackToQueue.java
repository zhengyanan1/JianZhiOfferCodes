package ten;

import java.util.Stack;

/**
 * Created by Administrator on 2016/12/23.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class TwoStackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    /**
       @author zhengyanan
       @date 2016/12/23 @time 17:15
       version_1
      31ms 654k
        思路：根据定义:stack 后进先出；Queue先进先出：
        stack1作为Queue队列，stack2作为辅助栈，辅助stack1进行模拟queue的操作；
    */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty())   throw new RuntimeException("The Queue is Empty!");

        int temp,result;
        while (!stack1.isEmpty()){
            temp = stack1.pop();
            stack2.push(temp);
        }
        result = stack2.pop();
        while (!stack2.isEmpty()){
            temp = stack2.pop();
            stack1.push(temp);
        }
        return result;
    }
}
