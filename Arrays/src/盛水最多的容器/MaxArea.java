package 盛水最多的容器;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-11-16 12:16
 **/
public class MaxArea {
    public static void main(String[] args) {
        int[] heights = {1,2,1};
        System.out.println(maxArea(heights));
    }

    public static int maxArea(int[] height){
        int max = 0;
        int p1 = 0;
        int p2 = height.length-1;
        while(p1<p2){
            max = Math.max(max,Math.min(height[p1],height[p2])*(p2-p1));
            if (height[p1]>=height[p2]){
                p2--;
            }else if(height[p1]<height[p2]){
                p1++;
            }
        }
        return max;
    }
}
