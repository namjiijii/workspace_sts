package test;

public class Test2 {
    public static void main(String[] args) {

        int[] lotto = new int[6];

        System.out.println("랜덤 숫자 : ");

        for(int i = 0; i < lotto.length; i++){
            lotto[i] = (int)(Math.random() * 46 + 1);
            System.out.print(lotto[i] + " , ");
        }
    }
}
