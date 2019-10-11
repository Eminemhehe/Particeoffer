package practice;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 若干个项目占用一个会场，每个项目由自己的开始时间和结束时间
 * 问如何安排，才能为1个会场安排最多的项目
 * 贪心策略：优先安排结束时间最早的项目；
 * */
public class BestArrange {

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;  //升序排列
        }

    }

    public static int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (cur <= programs[i].start) {
                result++;
                cur = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Program p1 = new Program(1, 4);
        Program p2 = new Program(2, 3);
        Program p3 = new Program(3, 5);
        Program p4 = new Program(6, 9);
        Program p5 = new Program(7, 10);
        Program p6 = new Program(5, 9);
        Program[] p = {p1, p2, p3, p4, p5, p6};
        System.out.println(bestArrange(p, 0));

    }

}
