package twenty;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/12/28.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class ClockWisePrint {
    public ArrayList<Integer> printMatrix(int [][] matrix) {



        /**
           @author zhengyanan
           @date 2016/12/28 @time 18:00
          version_2:
           运行时间：31ms O(n)
           占用内存：692k O(1)
         思路：跟version_1一样，根据打印的流程抽象出解题思路。但4个标记位的标记方式改进了，
         改为4个方向可访问的极限位置，比version_1里还要来回算、减的方式要更容易理解一些。
        */
        if (matrix == null) return null;

        int row = matrix.length;
        int column = matrix[0].length;

        int top,right,bottom,left;
        top = 0;
        right = column - 1;
        bottom = row - 1;
        left  = 0;

        int flag = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (true){
            flag = flag % 4;
            switch (flag){
                case 0:
                    for (int i = left; i <= right; i++) {
                        result.add(matrix[top][i]);
                    }
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom ; i++) {
                        result.add(matrix[i][right]);
                    }
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left ; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                    break;
                case 3:
                    for (int i = bottom; i >= top ; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
                    break;
            }
            if (top > bottom || left > right)  break;
            flag++;
        }
        return result;
        /**
           @author zhengyanan
           @date 2016/12/28 @time 17:31
           运行时间：30ms
           占用内存：692k
         version_1:
         思路：
         加4个辅助的标记top，right，bottom，left，分别记录从上右左下分别扫过了多少行，根据这些标记来
           进一步进行处理。
         显然，这基本上就是根据打印的流程抽象出来的解决问题的思路。
        */
//        if (matrix == null) return null;
//
//        int row = matrix.length;
//        int column = matrix[0].length;
//
//        int top,right,bottom,left;
//        top = right = bottom = left = 0;
//
//        int flag = 0;
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        while (true){
//            flag = flag % 4;
//            switch (flag){
//                case 0:
//                    for (int i = left; i < column - right ; i++) {
//                        result.add(matrix[top][i]);
//                    }
//                    top++;
//                    break;
//                case 1:
//                    for (int i = top; i < row - bottom ; i++) {
//                        result.add(matrix[i][column - 1 - right]);
//                    }
//                    right++;
//                    break;
//                case 2:
//                    for (int i = column - 1 - right; i >= left ; i--) {
//                        result.add(matrix[row - 1 - bottom][i]);
//                    }
//                    bottom++;
//                    break;
//                case 3:
//                    for (int i = row - 1 - bottom; i >= top ; i--) {
//                        result.add(matrix[i][left]);
//                    }
//                    left++;
//                    break;
//            }
//            if (top + bottom == row || left + right == column)  break;
//            flag++;
//        }
//        return result;
    }
    public static void main(String[] args){
        int[][] data = new int[][]{
                {1},
                {5},
                {9},
                {13}
        };
        ClockWisePrint clockWisePrint = new ClockWisePrint();

        System.out.println("ClockWisePrint.main():" + clockWisePrint.printMatrix(data));


    }
}
