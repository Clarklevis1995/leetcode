package 练习.贪心算法.合理安排宣讲会;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: leetcode
 * @description
 * @author: ClarkLevis
 * @create: 2020-12-14 13:35
 **/
public class BestArrange {
    public static class Program{
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString(){
            return "start: "+start+" end: "+end;
        }
    }

    /**
     * 按照项目的终止时间来设定比较器
     */
    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    /**
     * 求出在一天之内会议室可以安排的宣讲会的最大数量
     * @param programs 包含所有宣讲会的数组
     * @param current 当前时刻
     * @return 返回可以安排的宣讲会的数量
     */
    public static List<Program> bestArrange(Program[] programs, int current){
        ArrayList<Program> result = new ArrayList<>();
        Arrays.sort(programs, new ProgramComparator());

        for (int i = 0; i < programs.length; i++) {
            //只有满足在当前时间之后开始的项目才可以被安排
            if (current<=programs[i].start){
                result.add(programs[i]);
                current = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Program p1 = new Program(7,9);
        Program p2 = new Program(8,9);
        Program p3 = new Program(7,12);
        Program p4 = new Program(10,11);
        Program p5 = new Program(11,15);
        Program p6 = new Program(15,20);
        Program p7 = new Program(18,19);

        Program[] programs = new Program[7];
        programs[0] = p1;
        programs[1] = p2;
        programs[2] = p3;
        programs[3] = p4;
        programs[4] = p5;
        programs[5] = p6;
        programs[6] = p7;

        System.out.println(bestArrange(programs, 7));
    }
}
