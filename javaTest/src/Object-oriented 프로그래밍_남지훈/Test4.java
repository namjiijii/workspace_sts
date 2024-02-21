package test;

import java.util.PrimitiveIterator;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int a;
        int b;
        int c;

        int cnt = 0;

        System.out.println("1~999까지 숫자를 입력하세요 : ");
        num = sc.nextInt();

        if (num < 0 || num > 999) {
            System.out.println("숫자를 다시 입력해주세요");
        }

        a = num / 100; //백의 자리
        b = (num % 100)/ 10; //십의 자리
        c = (num % 100) % 10; //일의 자리


        if (a == 0){
            a = 1;
        }
        if (b == 0){
            b = 1;
        }
        if (c == 0){
            c = 1;
        }

        if (a % 3 == 0){
            cnt++;
        }
        if (b % 3 == 0){
            cnt++;
        }
        if (c % 3 == 0){
            cnt++;
        }

        if (cnt == 3){
            System.out.println("박수 3번");
        }
        if (cnt == 2){
            System.out.println("박수 2번");
        }
        if (cnt == 1){
            System.out.println("박수 1번");
        }
        if (cnt == 0){
            System.out.println("박수 0번");
        }
    }
}
