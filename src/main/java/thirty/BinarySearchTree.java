package thirty;

/**
 * Created by ASUS on 2017/2/14.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class BinarySearchTree {


    /**
    @author zhengyanan
    @time 15:37
    @description
        version_2:
        同1，主要是judge函数做了优化。
    运行时间：37ms
    占用内存：654k
     */
    private boolean judge(int[] sequence ,int start, int end) {
        if (start >= end)   return true;

        int root = sequence[end];
        int rightStart = -1;
        for (int i = start; i < end; i++) {
            if (sequence[i] > root){
                rightStart = i;
                break;
            }
        }
        if (rightStart == -1){
            //说明全部比root小
            return judge(sequence,start,end - 1);//包括 = -1 && = start两种情况
        }
        else {
            for (int i = rightStart; i < end ; i++) {
                if (sequence[i] < root) return false;
            }
            return judge(sequence,start,rightStart-1)
                    && judge(sequence,rightStart,end - 1);
        }
    }



    /**
    @author zhengyanan
    @time 15:32
    @description
        version_1:
        核心思路：
            1.二叉搜索树特点：左子树小于根，右子树大于根
            2.后序遍历特点 左右根
            3.可以根据后序遍历的最后一个元素，即根元素，将前面的序列分成 小于根的一部分序列和
        大于根的一部分序列，两个子序列仍然是满足题设要求的序列，递归调用。
            4.判断条件：如果大于根的一部分序列中出现小于根的，说明false；否则就递归调用，直到
        start>=end，返回true。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)   return false;
        return judge(sequence,0,sequence.length - 1);
    }

//    private boolean judge(int[] sequence ,int start, int end) {
//        if (start == end)   return true;
//
//        int root = sequence[end];
//        int rightStart = -1;
//        for (int i = start; i < end; i++) {
//            if (sequence[i] > root){
//                rightStart = i;
//                break;
//            }
//        }
//        if (rightStart == -1){
//            //说明全部比root小
//            return judge(sequence,start,end - 1);//包括 = -1 && = start两种情况
//        }
//        else if (rightStart == start){
//            for (int i = rightStart; i < end; i++) {
//                if (sequence[i] < root) return false;
//            }
//            return judge(sequence,rightStart,end - 1);
//        }
//        else {
//            for (int i = rightStart; i < end ; i++) {
//                if (sequence[i] < root) return false;
//            }
//            return judge(sequence,start,rightStart-1)
//                    && judge(sequence,rightStart,end - 1);
//        }
//    }


}
