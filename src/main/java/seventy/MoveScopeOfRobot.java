package seventy;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/13.
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 *因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MoveScopeOfRobot {


    /**
       @author zhengyanan
       @date 2017/3/14 @time 17:09
      version_3:回溯法
        核心思路：
            1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
            返回1 + 4 个方向的探索值之和。
            2.探索时，判断当前节点是否可达的标准为：
                1）当前节点在矩阵内；
                2）当前节点未被访问过；
                3）当前节点满足limit限制。
            3.
       运行时间：31ms
       占用内存：550k
    */
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];

        return countingSteps(threshold,rows,cols,0,0,visited);
    }

    public int countingSteps(int limit,int rows,int cols,int r,int c,boolean[][] visited){
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || visited[r][c] || bitSum(r) + bitSum(c) > limit)  return 0;

        visited[r][c] = true;
        return countingSteps(limit,rows,cols,r - 1,c,visited)
                + countingSteps(limit,rows,cols,r,c - 1,visited)
                + countingSteps(limit,rows,cols,r + 1,c,visited)
                + countingSteps(limit,rows,cols,r,c + 1,visited)
                + 1;
    }

    public int bitSum(int t){
        int count = 0;
        while (t != 0){
            count += t % 10;
            t /= 10;
        }
        return  count;
    }

    /**
       @author zhengyanan
       @date 2017/3/14 @time 16:26
      version_2:（此段代码有问题）
        核心思路：
            1.本来想的是遍历每一行，找到右端第一个不能到达的点，以此为界，此界点前的点都可以到达，之后的点
            机器人不可到达；
            2.但后来发现，这种思路有问题，机器人可以通过上一行或者下一行的格子进入此行界点之后的格子。
            经过测试，发现确实也存在这种情况。
    */
//    public int movingCount(int threshold, int rows, int cols){
//        int r,cMax, rSum,cSumMax;
//        int count = 0;
//        for (int i = 0; i < rows; i++) {
//            rSum = 0;
//            r = i;
//            while (r != 0){
//                rSum += r % 10;
//                r /= 10;
//            }
//            cSumMax = threshold - rSum;
//
//            if (cSumMax < 0)    break;
//            else{
//                int max = 0,numberOfNine,add;
//                numberOfNine = cSumMax / 9;
//                add = cSumMax % 9;
//                max = add + 1;
//                if (numberOfNine > 0){
//                    max = max * 10 + 9;
//                    numberOfNine--;
//                }
//                count += max < cols ? max : cols;
//                System.out.println(i+";"+(max < cols? max:cols));
//            }
//        }
//        return count;
//    }


    /**
       @author zhengyanan
       @date 2017/3/13 @time 16:48
        version_1:（此段代码有问题）
        核心思路：
            1.判断threshold 和 rows、cols 的关系，分情况讨论
     (PS:题意理解错误！！！原题应该是各数位之和，而不是 行数和列数的和。)
    */
//    public int movingCount(int threshold, int rows, int cols){
//        int smaller,bigger,result;
//        smaller = rows <= cols ? rows:cols;
//        bigger = rows + cols - smaller;
//
//        result = (threshold + 1) * (threshold + 1 + 1) / 2;
//        if (threshold <= smaller){
//
//        }
//        else if (threshold > smaller && threshold <= bigger){
//            int t, differ = threshold - smaller;
//            t = differ * (1 + differ) / 2;
//            result -= t;
//        }
//        else {
//            int t = 0,differ1,differ2;
//            differ1 = threshold - smaller;
//            differ2 = threshold - bigger;
//            t += differ1 * (1 + differ1) / 2;
//            t += differ2 * (1 + differ2) / 2;
//
//            result -= t;
//        }
//        return result;
//    }
    public static void main(String[] args){
        System.out.println(
                new MoveScopeOfRobot().movingCount(15,20,20)
        );

        int count = 0,iSum,jSum,tI,tJ,countLine;
        for (int i = 0; i < 20; i++) {
            countLine = 0;
            for (int j = 0; j < 20; j++) {
                tI = i;
                tJ = j;
                iSum = 0;
                jSum = 0;
                while (tI != 0){
                    iSum += (tI % 10);
                    tI /= 10;
                }
                while (tJ != 0){
                    jSum += (tJ % 10);
                    tJ /= 10;
                }
                if (iSum + jSum <= 15){
                    count++;
                    System.out.print(1 + " ");
                }
                else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();

            count += countLine;
        }
        System.out.println(count);
    }
}


/**
   @author zhengyanan
   @date 2017/3/14 @time 17:49
  牛客网推荐答案
*/
class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        int flag[][] = new int[rows][cols]; //记录是否已经走过        
        return helper(0, 0, rows, cols, flag, threshold);
    }
    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
            return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
        + helper(i + 1, j, rows, cols, flag, threshold)
        + helper(i, j - 1, rows, cols, flag, threshold)
        + helper(i, j + 1, rows, cols, flag, threshold)
        + 1;
    }
    private int numSum(int i) {
        int sum = 0;
        do{
            sum += i%10;
        }while((i = i/10) > 0);
        return sum;
    }
}
