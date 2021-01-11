package 搜索二维矩阵;

import org.w3c.dom.ls.LSOutput;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-27 22:44
 **/
public class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(target<matrix[0][0] || target>matrix[m-1][n-1]){
            return false;
        }

        //从右上角开始
        int i = 0;
        int j = n-1;
        while(i<=m-1 && j>=0){
            if(matrix[i][j]>target){
                j--;
            }else if(matrix[i][j]<target){
                i++;
            }else{
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        System.out.println(searchMatrix(matrix, 5));
    }
}
