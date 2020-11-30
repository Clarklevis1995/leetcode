package 练习.排序算法;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-25 08:05
 **/
public class 对数器 {
    public static void main(String[] args) {
        check();
    }
    static int[] generateRandomArray(){
        Random r = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000);
        }

        return arr;
    }

    static void check(){
        int[] arr = generateRandomArray();
        //must copy this array, or your method will deal with the same array as the standard methods deals with
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr,0,arr2,0, arr.length);

        Arrays.sort(arr);
        //SelectSort.selectSort(arr2);
        //BubbleSort.sort(arr2);
        //InsertSort.insertSort(arr2);
        //ShellSort.sort(arr2);
        //MergeSort.sort(arr2,0,arr2.length-1);
        //QuickSort.quickSort(arr2, 0, arr2.length-1);
        HeapSort.sort(arr2);
        boolean same = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=arr2[i]){
                same = false;
            }
        }
        System.out.println(same ?"right":"wrong");
    }

}
