package javaJungSuk_11;

import java.util.*;

class Student_2 implements Comparable{    // Comparable 인터페이스 상속
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student_2(String name,int ban,int no,int kor,int eng,int math){
        this.name=name;
        this.ban=ban;
        this.no=no;
        this.kor=kor;
        this.eng=eng;
        this.math=math;
    }

    int getTotal(){
        return kor +eng+math;
    }

    float getAverage(){
        return (int)((getTotal()/3f)*10+0.5)/10f;
    }

    public String toString(){
        return name +","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
    }

    public int compareTo(Object o){
        // 매개변수 o가 Student 타입인지 확인
        if(o instanceof Student){
            // o를 Student 타입으로 안전하게 형변환하여 tmp 변수에 저장
            Student tmp = (Student)o;

            // 현재 객체(this)의 name과 tmp.name을 비교하여 결과 반환
            // String 클래스의 compareTo()는 사전순(알파벳순) 비교를 수행
            return name.compareTo(tmp.name); // String 클래스의 compareTo()를 호출
        }
        else{
            // o가 Student 타입이 아니라면 -1을 반환( 비교 불가능을 의미 )
            return -1;
        }
    }
}

public class Exercise11_6 {

    // 평균 점수 구간 (from, to) 안의 학생 수를 계산
    static int getGroupCount(TreeSet tset, int from, int to){

        // 하한경계 : 모든 과목 점수를 from으로 하여 평균이 'from'이 되도록 생성
        Student_2 s1 = new Student_2("",0,0,from,from,from);
        // 상한경계 : 모든 과목 점수를 to로 하여 평균이 'to'가 되도록 생성
        Student_2 s2 = new Student_2("",0,0,to,to,to);

        // TreeSet에서 [s1, s2] 구간(끝 미포함)에 속한 원소 수를 반환(Comparator 기준)
        return tset.subSet(s1,s2).size();
    }

    public static void main(String[] args) {
        TreeSet set = new TreeSet(new Comparator(){ // 익명 클래스
            // TreeSet이 정렬/중복 판단에 사용할 비교 로직
            public int compare(Object o1, Object o2){
                // 두 인자가 모두 Student_2 타입인지 확인
                if(o1 instanceof Student_2 && o2 instanceof Student_2){
                    // 두 객체를 Student_2로 캐스팅
                    Student_2 s1 = (Student_2)o1;
                    Student_2 s2 = (Student_2)o2;

                    // 평균 차이를 정수로 변환해 비교(오름차순); 0이면 동등으로 간주 될 수 있음
                    return (int)(s1.getAverage() - s2.getAverage());
                }

                // 비교 불가능한 타입이면 음수 반환하여 o1이 더 작다고 처리
                return -1;

            }
        });

        set.add(new Student_2("홍길동",1,1,100,100,100));
        set.add(new Student_2("남궁성",1,2,90,70,80));
        set.add(new Student_2("김자바",1,3,80,80,90));
        set.add(new Student_2("이자바",1,4,70,90,70));
        set.add(new Student_2("안자바",1,5,60,100,80));

        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("[60~69] :"+getGroupCount(set,60,70));
        System.out.println("[60~69] :"+getGroupCount(set,70,80));
        System.out.println("[60~69] :"+getGroupCount(set,80,90));
        System.out.println("[60~69] :"+getGroupCount(set,90,101));

    }
}
