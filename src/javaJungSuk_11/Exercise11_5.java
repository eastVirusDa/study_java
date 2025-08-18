package javaJungSuk_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Student implements Comparable{    // Comparable 인터페이스 상속
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name,int ban,int no,int kor,int eng,int math){
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

public class Exercise11_5 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student("홍길동",1,1,100,100,100));
        list.add(new Student("남궁성",1,2,90,70,80));
        list.add(new Student("김자바",1,3,80,80,90));
        list.add(new Student("이자바",1,4,70,90,70));
        list.add(new Student("안자바",1,5,60,100,80));

        Collections.sort(list); // list에 저장된 요소들을 정렬한다. (compareTo()호출)
        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
