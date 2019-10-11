package Subject_demo;

/**
 * Created by wz on 2019/5/23.
 */
public class InstanceVariableInitializer {
    private int i = 1;
    private int j = i + 1;
    public InstanceVariableInitializer(int var) {
        System.out.println(i);
        System.out.println(j);
        this.i = var;
        System.out.println(i);
        System.out.println(j);
    }
    {               // 实例代码块
        j += 3;
    }
    public static void main(String[] args) {
/*        再调用这个方法时，首先为i，j赋初始值0，此时进入println(i)，将对i进行赋值操作，i=1；
        接下来println(j)，对j进行赋值操作，j=2，然后进入代码块 j+=3，j=5
        this.i = var  i = 8; j =5       */
        new InstanceVariableInitializer(8);
    }
}

