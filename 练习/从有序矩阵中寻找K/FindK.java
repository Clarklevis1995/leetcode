package 练习.从有序矩阵中寻找K;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-02 08:45
 **/
public class FindK {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,6},
                {2,5,7,9},
                {4,6,8,10}
        };
        System.out.println(findK(matrix,12));
    }

    public static boolean findK(int[][] matrix, int k){
        //从右上角开始寻找，如果当前数大于K，则该列中的数都会比K大，切换到前一列
        int row = 0;
        int col = matrix[0].length-1;
        //边界条件：如果k不在当前矩阵范围内，返回false
        if (k<matrix[0][0] || k>matrix[matrix.length-1][matrix[0].length-1]){
            return false;
        }
        //终止条件：到达左下角
        while(!(row == matrix.length-1&& col == 0)){
            if (matrix[row][col] > k){
                col--; // 因为已经确定了边界条件，这里不会出现越界问题了
            }else if (matrix[row][col] == k){
                return true;
            }else {
                while(row<matrix.length){
                    if (matrix[row][col] == k){
                        return true;
                    }else if(matrix[row][col] < k){
                        row++;// 因为已经确定了边界条件，这里不会出现越界问题了
                    }else {
                        col--;
                        break;
                    }
                }
            }
        }
        return false;
    }
}
