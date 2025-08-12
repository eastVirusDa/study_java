package javaJungSuk_7;

class Outer_2{
    static class Inner{
        int iv=200;
    }
}

public class Exercise7_26 {
    public static void main(String[] args) {
        Outer_2.Inner inner = new Outer_2.Inner();
        System.out.println(inner.iv);
    }
}
