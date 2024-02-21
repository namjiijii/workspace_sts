package test;

public class Test3 {
    public static void main(String[] args) {
        int[] arr = {5, 11, 20, 40, 30};

        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
            else if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("가장 큰 값 : " + max + "가장 작은 값 : " + min);

    }
}
