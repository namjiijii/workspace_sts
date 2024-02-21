package test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        int[] baseball = new int[3];

        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < baseball.length; i++){
            baseball[i] = (int) (Math.random() * 9 + 1);

            for(int j = 0; j < i; j++){
                //중복 확인
                if (baseball[i] == baseball[j]){
                    // i를 마이너스를 하면 가장 가까운 for문으로 가며 i++을 다시 해서
                    // 값이 중복되지 않을 때까지 돌아온다
                    i--;
                    break;
                }
            }
        }
        System.out.println("---만들어진 배열---");
        System.out.println(Arrays.toString(baseball));

        System.out.println("숫자를 정했습니다. 게임을 시작합니다");

        int[] answer = new int[3];
        int cnt = 0;
        while (true){
            System.out.print(++cnt + " >> " );
            answer[0] = sc.nextInt();
            answer[1] = sc.nextInt();
            answer[2] = sc.nextInt();

            //스트라이크 , 볼 계산
            int strike = 0;
            int ball = 0;
            //j는 baseball
            for (int j = 0; j < answer.length; j++){
                for (int i = 0; i < answer.length; i++){
                    if (baseball[j] == answer[i]){
                        if (i == j){
                            strike++;
                        }
                        else{
                            ball++;
                        }
                    }
                }
            }
            System.out.println(strike + "스트라이크" + ball + "볼");
            if (strike == 3){
                System.out.println(cnt + "회 만에 숫자를 맞췄습니다");
                break;
            }
        }






    }
}
