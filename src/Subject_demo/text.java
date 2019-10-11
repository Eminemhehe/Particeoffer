package Subject_demo;


/**
 * Created by wz on 2019/7/16.
 */
public class text {
    public static void main(String[] args) {
/*       A a = new B();
       a.speak();

       B b =new C();
       b.speak();*/

   /*   Integer i1=99;
      int i2= 99;
      Integer i3= Integer.valueOf(99);
      Integer i4 = new Integer(99);
      System.out.println(i1==i2);
        System.out.println(i1==i3);
        System.out.println(i3==i4);
        System.out.println(i2==i4);*/
   /* char c = 1;
    short s = 1;
    byte b =1;
    int i  =1;
    c= (char) b;
    i=c;*/
   String s ="ss";
   Integer i = new Integer(522);
   Integer j = new Integer(522);
   System.out.println(i.hashCode());
   System.out.println(j.hashCode());
    }
}

class A {
    public void speak(){
        speak1();
    }
    public void speak1(){
        System.out.println("A");
    }
}

class B extends A {
    public void speak1() {
        System.out.println("B");
    }
}

class C extends B {
    public void speak() {
        super.speak();
    }
    public void speak1(){
        System.out.println("C");
    }
}


