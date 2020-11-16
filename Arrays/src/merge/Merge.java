package merge;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-14 20:11
 **/
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[]nums1, int m, int[]nums2, int n){
        if (n == 0){
            return;
        }
        int pointer1 = 0;
        int pointer2 = 0;
        int[] result = new int[m+n];
        for (int i = 0; i < nums1.length; i++) {
            if (pointer1<m&&pointer2<n&&nums1[pointer1]<=nums2[pointer2]){
                result[i] = nums1[pointer1];
                pointer1++;
            }else if(pointer1<m&&pointer2<n&&nums1[pointer1]>nums2[pointer2]){
                result[i] = nums2[pointer2];
                pointer2++;
            } else if(pointer1==m){
                result[i] = nums2[pointer2];
                pointer2++;
            }else if(pointer2==n){
                result[i] = nums1[pointer1];
                pointer1++;
            }
        }
        System.arraycopy(result,0,nums1,0,nums1.length);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        int p = nums1.length-1;
        int p1 = m-1;
        int p2 = n-1;
        while(p1>=0&&p2>=0){
            if (nums1[p1]>nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
}
