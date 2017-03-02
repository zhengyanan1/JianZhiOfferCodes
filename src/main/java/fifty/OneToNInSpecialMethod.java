package fifty;

/**
 * Created by Administrator on 2017/3/2.
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class OneToNInSpecialMethod {
    /**
       @author zhengyanan
       @date 2017/3/2 @time 11:12
       verison_1:
       核心思路：
        1.不能用循环，可以用递归呀，但得想个办法来判断终止点，即：递归终结的条件。
        2.可以利用 && 的短路特性，来构造递归终结条件。

       运行时间：28ms
       占用内存：688k
    */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}
