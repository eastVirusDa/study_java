package javaJungSuk_7;

class Outer_3{
    int value =10;

    class Inner{
        int value =20;
        void method1(){
            int value = 30;

            System.out.println(value);
            System.out.println(Inner.this.value);
            System.out.println(Outer_3.this.value);
        }
    }
}

public class Exercise7_27 {
    public static void main(String[] args) {

        Outer_3 outer=new Outer_3();
        Outer_3.Inner inner=outer.new Inner();

        inner.method1();
    }
}
