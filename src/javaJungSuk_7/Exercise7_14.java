package javaJungSuk_7;

class SutdaCard_2{
    final int num;
    final boolean isKwang;

    SutdaCard_2() {
        this(1, true);
    }

    SutdaCard_2(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // info() 대신 Object 클래스의 toString()을 오버라이딩했따.
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Exercise7_14 {
    public static void main(String[] args) {
        SutdaCard_2 c = new SutdaCard_2(1, true);
    }
}
