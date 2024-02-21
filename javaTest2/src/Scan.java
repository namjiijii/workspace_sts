import java.util.Scanner;

public class Scan {
    public static void main(String[] args) {

        int max;
        int mid;
        int min;

        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 수 : ");
        int num1 = sc.nextInt();
        System.out.println("두번째 수 : ");
        int num2 = sc.nextInt();
        System.out.println("세번째 수 : ");
        int num3 = sc.nextInt();

        if (num1 > num2 && num1 > num3){
            max = num1;

        }

    }
}
