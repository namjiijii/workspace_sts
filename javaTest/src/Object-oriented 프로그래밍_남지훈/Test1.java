package test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int mid = 0;
        int min = 0;

        //키보드로 입력받은 값
        System.out.println("첫번째 수 : ");
        int num1 = sc.nextInt();
        System.out.println("두번째 수 : ");
        int num2 = sc.nextInt();
        System.out.println("세번째 수 : ");
        int num3 = sc.nextInt();

        //가장 큰 수
        if (num1 > num2 && num1 > num3){
            max = num1;
            if (num2 > num3){
                mid = num2;
                min = num3;
            }
            else{
                mid = num3;
                min = num2;
            }
        }

        else if(num2 > num1 && num2 > num3){
            max = num2;
            if (num1 > num3){
                mid = num1;
                min = num3;
            }
        }
        else {
            max = num3;
            if (num1 > num2){
                mid = num1;
                min = num2;
            }
            else {
                mid = num2;
                min = num1;
            }
        }

        System.out.println(max + " > " + mid + " > " + min);




    }
}
