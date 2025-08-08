public class Exercise6_4 {
    public static void main(String[] args) {
        Student s = new Student();

        System.out.println("이름:"+s.name);
        System.out.println("총점:"+s.getTotal());
        System.out.println("평균:"+s.getAverage());

        //6-5
        Student s1 = new Student("홍길동",1,1,100,60,76);
        System.out.println(s1.info());
    }
}

class Student {
    public String name;
    public int ban;
    public int no;
    public int kor;
    public int eng;
    public int math;

    // 6-4
    public int getTotal(){
        return no+kor+eng+math;
    }
    public float getAverage(){
        return (kor+eng+math)/3f;
    }

    // 6-5
    Student(){
        this.name = "홍길동";
        this.ban = 1;
        this.no = 1;
        this.kor = 100;
        this.eng = 60;
        this.math = 76;
    }
    Student(String name, int ban, int no, int kor, int eng, int math){
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    public String info()
    {
        return (name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math);
    }
}
