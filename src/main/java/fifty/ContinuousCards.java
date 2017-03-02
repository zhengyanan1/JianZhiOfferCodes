package fifty;

/**
 * Created by Administrator on 2017/3/1.
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成
 * 任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
 * “So Lucky!”。LL决定去买体育彩票啦。
 *
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class ContinuousCards {
    /**
       @author zhengyanan
       @date 2017/3/1 @time 10:54
      version_2:
        核心思路：
            1.在verison_1的思路上进一步优化：
                当从counts[i]访问到counts[i+5]时，对于访问数组边界而提前退出访问的情况，我们考虑将counts
                的长度+4,，从而将这种特殊情况统一到常规情况中，从而简化处理逻辑，精简代码。

       运行时间：36ms
       占用内存：528k

    */
    public boolean isContinuous(int [] numbers) {
        int[] counts = new int[18];
        for (int num:numbers)   counts[num]++;
        int left,i;
        for (left = 1; left <14; left++) {
            if (counts[left] != 0)  break;
        }
        //用left记下最小的一个非0数字

        for (i = left + 1; i <= left+4; i++) {
            if (counts[i] == 0){
                if (counts[0] == 0) return false;
                else                counts[0]--;
            }
        }

        return true;
    }
    /**
       @author zhengyanan
       @date 2017/3/1 @time 10:25
       verison-1：
        核心思路：
            1.先用一个长度为14的数组，记忆原始数据，下标为值，值为下标出现的次数。
            2.按下标从小到大找到第一个不为0的数counts[i]（一定有，因为一共5个数，撑死4个0）。
            3.从counts[i]访问到counts[i+5]：
                如果counts[i] == 0：就counts[0]--,（类比成拿一个0来顶）；如果没有0可以用来顶，说明没法构成顺子，返回false；
            如果能顺利的访问完，就说明是顺子；

            如果不能访问完，就说明因为访问到了数组的边界而提前退出访问了。（比如 0,0,12,12,13）
            这时我们就需要判断 已经连成的顺子的长度+counts[0]是否==5.
                如果相等，就可以把0补到最左边组成顺子，true；
                如果不等，说明有非0的对子，false；

       运行时间：28ms
       占用内存：503k
    */
//    public boolean isContinuous(int [] numbers) {
//        int[] counts = new int[14];
//        for (int num:numbers)   counts[num]++;
//        int left,i;
//        for (left = 1; left <14; left++) {
//            if (counts[left] != 0)  break;
//        }
//        //用left记下最小的一个非0数字
//
//        for (i = left + 1; i <= left+4 && i<14  ; i++) {
//            if (counts[i] == 0){
//                if (counts[0] == 0) return false;
//                else                counts[0]--;
//            }
//        }
//
//        if (i == left + 5)  return true;
//        else{
//            if (14 - left + counts[0] == 5) return true;
//            else                            return false;
//        }
//    }
}
