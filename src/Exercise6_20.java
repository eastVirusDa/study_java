public class Exercise6_20 {
    public static int[] shuffle(int[] arr){
        int[] result = arr.clone();

        for(int i = 0; i<result.length; i++){
            int j = (int)(Math.random()*result.length);
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original)); //배열의 내용을 문자열로 출력

        int[] result = shuffle(original);
        System.out.println(java.util.Arrays.toString(result)); //배열의 내용을 문자열로 출력
    }
}
