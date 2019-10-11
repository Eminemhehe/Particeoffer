package practice;

public class IsBalancedTree {
    /**平衡二叉树：每个节点的左右子树的高度差不超过1
     * 处理二叉树：使用递归函数，回到节点三次，收集左子树和右子树的信息
     * 对于某一个节点：
     *     左子树平衡？
     *     右子树平衡？
     *     左子树高度？
     *     右子树高度？
     * */
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


/*    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }*/

    public static class ReturnData {
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isB(Node head) {
        return process(head).isB;
    }

    public static ReturnData process(Node head) {
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(head.left);
        if (leftData.isB == false) {
            return new ReturnData(false, 0);
        }
        ReturnData rigthData = process(head.right);
        if (rigthData.isB == false) {
            return new ReturnData(false, 0);
        }
        if (Math.abs(leftData.h - rigthData.h) > 1) {
            return new ReturnData(false, 0);
        }
        //左树后右树中最大值+1
        return new ReturnData(true, Math.max(leftData.h, rigthData.h) + 1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        //System.out.println(isBalance(head));
        System.out.println(isB(head));

    }

}
