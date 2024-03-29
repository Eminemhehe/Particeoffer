package practice;

public class Hanoi {
/**
 * 汉诺塔问题
 *
 * */
    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }
    }

    public static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(rest - 1, down - 1, help, from, to);
        }
    }

    //N:1~N  开始时
    public static void process(int N, String from, String to, String help) {
        //form只剩下1，只需要将1从from到to；help是中间可借助的一个过程
        if (N == 1) {
            System.out.println("Move 1  from" + from + " to " + to);
        } else {
            process(N - 1, from, help, to);//将n-1从form移动到help，可借助to（form最终只剩下n）
            System.out.println("Move " + N + " from " + from + " to " + to); //将N从from移动到to(将from剩下的n移动到to)
            process(N - 1, help, to, from);//将help上的N-1移动回to，可借助from
        }

    }


    public static void moveLeftToRight(int N) {
        if (N == 1) {
            System.out.println("move 1 from left to right");
        }
        moveLeftToMid(N - 1);
        System.out.println("move " + N + "from left to right");
        moveMidToRight(N - 1);
    }

    public static void moveRightToLeft(int N) {

    }

    public static void moveLeftToMid(int N) {
        if (N == 1) {
            System.out.println("move 1 from left to mid");
        }
        moveLeftToRight(N - 1);
        System.out.println("move " + N + "from left to mid");
        moveRightToMid(N - 1);
    }

    public static void moveMidToLeft(int N) {

    }

    public static void moveRightToMid(int N) {

    }

    public static void moveMidToRight(int N) {
        if (N == 1) {
            System.out.println("move 1 from mid to right");
        }
        moveMidToLeft(N - 1);
        System.out.println("move " + N + "from mid to right");
        moveLeftToRight(N - 1);
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

}
