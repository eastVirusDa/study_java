package javaJungSuk_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Student_4 implements Comparable {    // Comparable 인터페이스 상속
    String name;
    int ban;
    int no;
    int kor, eng, math;

    int total; // 총점
    int schoolRank; // 전교등수

    Student_4(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        total = kor + eng + math;
    }

    int getTotal() {
        return total;
    }

    float getAverage() {
        return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
    }


    public int compareTo(Object o) {
        // 매개변수 o가 Student 타입인지 확인
        if (o instanceof Student) {
            // o를 Student 타입으로 안전하게 형변환하여 tmp 변수에 저장
            Student tmp = (Student) o;

            // 현재 객체(this)의 name과 tmp.name을 비교하여 결과 반환
            // String 클래스의 compareTo()는 사전순(알파벳순) 비교를 수행
            return name.compareTo(tmp.name); // String 클래스의 compareTo()를 호출
        } else {
            // o가 Student 타입이 아니라면 -1을 반환( 비교 불가능을 의미 )
            return -1;
        }
    }

    public String toString() {

        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage() + ", " + schoolRank;
    }

}

public class Exercise11_8 {
    public static void calculateSchoolRank(List list) {
        Collections.sort(list); // 먼저 list를 총점 기준 내림차순으로 정렬한다.

        int prevRank = -1;   // 이전 전교 등수
        int prevTotal = -1; // 이전 총점
        int length = list.size();

        /*
    아래의 로직에 맞게 코드를 작성하시오 (2) .
    1. 반복문을 이용해서 list에 저장된 Student_4객체를 하나씩 읽는다.
        1.1 총점(total)이 이전 총점(prevTotal)과 같으면
                이전 등수(prevRank)를 등수(shcoolRank)로 한다.
        1.2 총점이 서로 다르면,
            등수(schollRank)의 값을 알맞게 계산해서 저장한다.
            이전에 동점자 였다면, 그 다음 등수를 동점자의 수를 고려해야 하낟.
        1.3 현재 총점과 등수를 이전 총점(prevTotal)과 이전등수(prevRank)에 저장한다.
    */
        for(int i=0;i<length;i++) {
            Student_4 s=(Student_4)list.get(i);

            if(s.total == prevTotal){
                s.schoolRank = prevRank;
            }
            else {
                s.schoolRank = i + 1;
            }
            prevRank = s.schoolRank;
            prevTotal = s.total;
        }

    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student_4("이자바", 2, 1, 70, 90, 70));
        list.add(new Student_4("안자바", 2, 2, 60, 100, 80));
        list.add(new Student_4("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student_4("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student_4("김자바", 1, 2, 80, 80, 90));

        calculateSchoolRank(list);

        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
