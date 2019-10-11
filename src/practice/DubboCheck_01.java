package practice;

public class DubboCheck_01 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static class Singerton{
        private Singerton(){}
        private static volatile  Singerton singerton;
        private static Singerton getSingerton(){
            if(singerton==null){
                synchronized (Singerton.class){
                    if(singerton==null){
                        singerton = new Singerton();
                    }
                }
            }
            return  singerton;
        }
    }
}
