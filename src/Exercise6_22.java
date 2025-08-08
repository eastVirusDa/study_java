public class Exercise6_22 {
    public static boolean isNumber(String str){
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
             if(!Character.isDigit(ch)){ // 내가 짠 코드
            //if(!('0'<=ch && ch<='9')){ //  강사님 추천
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "123";
        System.out.println(str+"는 숫자입니까? "+ isNumber(str));

        str="1234o";
        System.out.println(str+"는 숫자입니까? "+ isNumber(str));
    }
}
