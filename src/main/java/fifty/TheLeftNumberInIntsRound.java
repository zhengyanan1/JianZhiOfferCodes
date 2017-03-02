package fifty;

/**
 * Created by Administrator on 2017/3/1.
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再
 * 回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后
 * 一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 *
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class TheLeftNumberInIntsRound {

    /**
       @author zhengyanan
       @date 2017/3/1 @time 11:12
        version_1:
       核心思路：
            1.根据题意，模拟一个环形链表模型
            2.需要注意的点：
                （1）由于最开始就已经指向第一个节点，所以初始进入计步逻辑时要停一步；
                （2）内层循环每次只走m-1步，然后将第m步会访问的结点从环形链表中去掉。
       复杂度：时间O(m*n)；空间O(n)；
       运行时间：54ms
       占用内存：629k
    */

    public int LastRemaining_Solution(int n, int m) {
        if (m * n == 0) return -1;

        int[] data = new int[n];
        int t;
        for (int i = 0; i < n; i++) {
            data[i] = i + 1;
        }
        data[n-1] = 0;
        //构建环形链表

        t = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (i != 0 || j != 0){
                    t = data[t];
                }
            }

            data[t] = data[data[t]];
        }

        return t;
    }
}
