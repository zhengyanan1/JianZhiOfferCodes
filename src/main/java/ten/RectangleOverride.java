package ten;

/**
 * Created by Administrator on 2016/12/26.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectangleOverride {
    public int RectCover(int target) {

        /**
           @author zhengyanan
           @date 2016/12/26 @time 15:03
          version_1:
         经分析：发现，此题的实际效果跟青蛙跳是一样的
        */
        if (target == 0)    return 0;
        else if (target == 1)    return 1;
        else if (target == 2)   return 2;

        int fn1 = 2,fn2 = 1;
        while (target >2){
            fn1 += fn2;
            fn2 = fn1 - fn2;
            target -- ;
        }
        return fn1;

    }
    public static void main(String[] args){

    }
}
