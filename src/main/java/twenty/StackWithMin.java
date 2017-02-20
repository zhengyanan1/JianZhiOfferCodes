package twenty;

import java.util.Stack;

/**
 * Created by Administrator on 2016/12/28.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 */
public class StackWithMin {


    /**
       @author zhengyanan
       @date 2016/12/28 @time 18:40
      version_1:
       运行时间：30ms
       占用内存：629k
     思路：
        根据定义，每次都遍历Stack，找到最小值，再把Stack复原。
    */
    private Stack mData = new Stack();

    private Stack mHelper = new Stack();
    public void push(int node) {
        mData.push(node);
    }

    public void pop() {
        mData.pop();
    }

    public int top() {
        return (Integer) mData.peek();
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        while (!mData.isEmpty()){
            min =  min < top() ? min:top();
            mHelper.push(mData.pop());
        }
        while (!mHelper.isEmpty()){
            push((Integer) mHelper.pop());
        }
        return min;
    }
}
