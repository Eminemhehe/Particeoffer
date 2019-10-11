package Subject_demo;

import java.util.Scanner;

/**
 * Created by wz on 2019/7/7.
 */
public class toutiao_1 {
    public static void main(String[] args) {
        int Studentnum;
        int Score;
        Scanner in = new Scanner(System.in);
        Studentnum = in.nextInt();//Studentnum表示每组派出人数；
        int[] speed = new int[Studentnum];
        int[] speed2 = new int[Studentnum];
        for (int i = 0; i < Studentnum; i++) {
            speed[i] = in.nextInt();
        }
        for (int i = 0; i < Studentnum; i++) {
            speed2[i] = in.nextInt();
        }
        Score = getScoer(speed, speed2, Studentnum);
        System.out.println(Score);
    }

    private static int getScoer(int[] speed, int[] speed2, int num) {
        int score = 0;
        for (int i = 0; i < num; i = i + 1) {
            if (speed[i] > speed2[i]) {
                score = score + 1;
            }
            if (speed[i] < speed2[i]) {
                score = score - 1;
            }
        }
        return score;
    }
}

