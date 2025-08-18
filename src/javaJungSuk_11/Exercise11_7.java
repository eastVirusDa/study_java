package javaJungSuk_11;

import java.util.*;

class Student_3{    // Comparable 인터페이스 상속
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student_3(String name,int ban,int no,int kor,int eng,int math){
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
}

// BanNoAscending 클래스 : Student_3 객체를 반(ban)과 번호(no) 기준으로 오름차순 정렬하기 위한 Comparator
class BanNoAscending implements Comparator{
    // 두 객체를 비교하는 메서드
    public int compare(Object o1, Object o2) {
        // 두 객체가 모두 Student_3 타입인지 확인
        if(o1 instanceof Student_3 && o2 instanceof Student_3){
            // 두 객체를 Student_3로 형변환
            Student_3 s1 = (Student_3)o1;
            Student_3 s2 = (Student_3)o2;

            // 먼저 반(ban) 값을 비교(오름차순)
            int result = s1.ban-s2.ban;

            if(result == 0) { // 반이 같으면, 번호를 비교한다.
                return s1.no-s2.no;
            }
            // 반이 다르면 반의 차이를 반환해 정렬 기준으로 사용
            return result;

            // 위의 코드를 삼항연산자를 이용하여 작성하면 다음과 같다.
            // return s1.ban == s2.ban ? s1.no - s2.no : s1.ban - s2.ban;
        }
        // 비교 대상이 Student_3가 아니면 음수 반환
        return -1;
    }
}

public class Exercise11_7 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Student_3("이자바",2,1,70,90,70));
        list.add(new Student_3("안자바",2,2,60,100,80));
        list.add(new Student_3("홍길동",1,3,100,100,100));
        list.add(new Student_3("남궁성",1,1,90,70,80));
        list.add(new Student_3("김자바",1,2,80,80,90));

        Collections.sort(list,new BanNoAscending());

        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}
